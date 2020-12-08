package kr.co.coroutine_retrofit_dagger.data.entity

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("message") val message: T,
    @SerializedName("status") val status: String
)