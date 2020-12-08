package kr.co.coroutine_retrofit_dagger.data

import kr.co.coroutine_retrofit_dagger.data.entity.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("breed/{breedName}/images/random")
    suspend fun getImageByUrl(@Path("breedName") breedName: String): ApiResponse<String>

    @GET("breeds/list/all")
    suspend fun getBreedsList(): ApiResponse<Map<String, List<String>>>

    @GET("breeds/list/all")
    fun getBreedsListAsync(): Call<ApiResponse<Map<String, List<String>>>>

    @GET("breed/{breedName}/images/random")
    fun getImageByUrlAsync(@Path("breedName") breedName: String): Call<ApiResponse<String>>
}