package dev.chu.architecture.data.remote

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q: String = "stars:>1",
        @Query("sort") sort: String = "stars",
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1
    ): Call<JsonObject>

}