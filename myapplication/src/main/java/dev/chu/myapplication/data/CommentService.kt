package dev.chu.myapplication.data

import dev.chu.myapplication.data.entity.Comment
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentService {
    @GET("/comments")
    fun getComments(@Query("postId") id: Long) : Single<List<Comment>>
}