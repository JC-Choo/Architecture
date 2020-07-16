package kr.co.coroutine_retrofit_dagger.ui.main

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.co.coroutine_retrofit_dagger.data.Status
import kr.co.coroutine_retrofit_dagger.data.entity.ApiResponse
import kr.co.coroutine_retrofit_dagger.data.entity.Dog
import kr.co.coroutine_retrofit_dagger.util.logCoroutineThreadNameOnly
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    companion object {
        private const val DELAY_BETWEEN_DOGS_IN_MS = 10000L
    }

    private val parentJob = SupervisorJob()

    private val _dogList = MutableLiveData<List<Dog>>()
    private val _status = MutableLiveData<String?>()
    private val _snackbar = MutableLiveData<String?>()
    private val _loading = MutableLiveData(false)

    val dogList: LiveData<List<Dog>>
        get() = _dogList
    val snackbar: LiveData<String?>
        get() = _snackbar
    val status: LiveData<String?>
        get() = _status
    val loading: LiveData<Boolean>
        get() = _loading

    fun onSnackbarShown() {
        _snackbar.value = null
    }

    val liveDataResult = liveData {
        "liveDataResult".logCoroutineThreadNameOnly()
        emit(Status.Loading(true))
        emitSource(getTopTwoDogsLiveData())
    }

    private fun getTopTwoDogsLiveData(): LiveData<Status> = liveData {
        while (true) {
            kotlinx.coroutines.delay(DELAY_BETWEEN_DOGS_IN_MS)
            val topTwoDogsResult = repository.getTopTwoDogsAsync()
            emit(topTwoDogsResult)
        }
    }

    fun loadDogListAsync() {
        parentJob.cancelChildren()
        _dogList.value = emptyList()
        loadData {
            _status.postValue("Loading....")
            val start = System.currentTimeMillis()
            val result = runCatching { repository.getListDogsAsync() }
            result.onSuccess {
                _status.value = getTimeDifference(start)
                _dogList.value = it
            }.onFailure {
                _status.postValue("Failed.")
                _snackbar.postValue("loadDogListAsynchronously() " + it.message.toString())
            }
        }
    }

    private fun getTimeDifference(start: Long): String {
        val difference = System.currentTimeMillis() - start
        val timeTaken = buildString {
            append(difference / 1000)
            append(" seconds")
        }
        return timeTaken.toString()
    }

    private fun loadData(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _loading.value = true
                block()
            } catch (error: Throwable) {
                //show error
            } finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancelChildren()
    }
}