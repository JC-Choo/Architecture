package dev.chu.myapplication.data

import dev.chu.myapplication.data.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/users/{userId}")
    fun getUser(@Path("userId") userId: Long): Single<User>
}