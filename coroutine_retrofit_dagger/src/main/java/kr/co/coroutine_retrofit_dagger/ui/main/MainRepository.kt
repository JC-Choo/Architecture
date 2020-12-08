package kr.co.coroutine_retrofit_dagger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kr.co.coroutine_retrofit_dagger.data.ApiService
import kr.co.coroutine_retrofit_dagger.data.Status
import kr.co.coroutine_retrofit_dagger.data.entity.ApiResponse
import kr.co.coroutine_retrofit_dagger.data.entity.Dog
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

// https://medium.com/@shivamdhuria/learn-by-doing-coroutines-a-guide-for-using-coroutines-in-android-for-retrofit-requests-eaef6ca58c7e
class MainRepository @Inject constructor(private val service: ApiService) {

//    suspend fun getBreedsList(): LiveData<Map<String, List<String>>> {
//        val result = MutableLiveData<Map<String, List<String>>>()
//
//        withContext(Dispatchers.Default) {
//            result.postValue(service.getBreedsList().message)
//        }
//    }

    suspend fun getBreedsList() = service.getBreedsList()
//        withContext(Dispatchers.Default) {
//            val response = service.getBreedsList()
//            if(response.status == "success") {
//                return@withContext response.message
//            } else {
//                return@withContext response.status
//            }
//        }

    suspend fun getImageByUrl(breedName: String) = service.getImageByUrl(breedName)

    suspend fun getListDogsAsync(): List<Dog> {
            val list = mutableListOf<Dog>()
            val dogBreedList = service.getBreedsList().message.keys.toList()
//            dogBreedList.forEach {
//                val dogImage = service.getImageByUrl(it).message
//                list.add(Dog(it, dogImage))
//            }

            withContext(Dispatchers.IO) {

                dogBreedList.map {
                    async { service.getImageByUrl(it) }
                }.awaitAll().forEach {
                    list.add(Dog(extractBreedName(it.message), it.message))
                }
            }
            return list
    }

    private fun extractBreedName(message: String): String? {
        val breedName = message.substringAfter("breeds/").substringBefore("/")
        return breedName.replace(Regex("-"), " ").capitalize()
    }

    suspend fun getTopTwoDogsAsync(): Status = withContext(Dispatchers.IO) {
        // We need to move to background thread, "Dispatchers.IO" in this case as Network requests must always operate on background thread.
        val list = mutableListOf<Dog>()
//        logCoroutine("getTopTwoDogsAsync", coroutineContext)

        //The async{} builder immediately spawns the Coroutine inside the blocks.
        val dogBreedListDeferred = async { service.getBreedsListAsync().execute() }
        //The .await() pauses the function until the deferred val returns a result.
        val dogBreedListResponse = dogBreedListDeferred.await()

        if (dogBreedListResponse.isSuccessful) {

            //Selecting two dog breeds by Random
            val dogBreedOneName = dogBreedListResponse.body()?.message?.keys?.toList()?.random()
            val dogBreedTwoName = dogBreedListResponse.body()?.message?.keys?.toList()?.random()

            //Spawning two Coroutines by using async{} again.
            val dogBreedOneImageDeferred = async {
//            logCoroutine("dogBreedOneImageDeferred", coroutineContext)
                dogBreedOneName?.let { service.getImageByUrlAsync(it).execute() }
            }
            val dogBreedTwoImageDeferred = async {
//            logCoroutine("dogBreedTwoImageDeferred", coroutineContext)
                dogBreedTwoName?.let { service.getImageByUrlAsync(it).execute() }
            }

            //Await for both the started coroutines above by using await on the deferred val .
            val dogBreedOne = dogBreedOneImageDeferred.await()
            val dogBreedTwo = dogBreedTwoImageDeferred.await()

            if (dogBreedTwo?.isSuccessful!!) list.add(Dog(dogBreedTwoName?.capitalize(), dogBreedTwo.body()?.message))
            if (dogBreedOne?.isSuccessful!!) list.add(Dog(dogBreedOneName?.capitalize(), dogBreedOne.body()?.message))
            Status.Success(list)
        } else {
            Status.Error("Something went wrong")
        }

    }
}