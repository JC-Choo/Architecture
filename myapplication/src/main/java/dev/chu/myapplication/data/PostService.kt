package dev.chu.myapplication.data

import dev.chu.myapplication.data.entity.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    fun getPosts(): Single<List<Post>>
}