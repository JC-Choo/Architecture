package dev.chu.architecture.data.remote

import dev.chu.architecture.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    private val BASE_URL = "https://api.github.com/"

    private val okHttpClientBuilder =
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
            })
        }

    fun <T> createService(serviceClass: Class<T>): T =
        Retrofit.Builder()
            .client(okHttpClientBuilder.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
}