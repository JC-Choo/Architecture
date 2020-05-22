package dev.chu.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dev.chu.myapplication.data.CommentService
import dev.chu.myapplication.data.PostService
import dev.chu.myapplication.data.UserService
import retrofit2.Retrofit

@Module
class RetrofitModule {
    @Provides
    @Reusable
    fun providePostService(retrofit: Retrofit) : PostService {
        return retrofit.create(PostService::class.java)
    }

    @Provides
    @Reusable
    fun provideUserService(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Reusable
    fun provideCommentService(retrofit: Retrofit) : CommentService {
        return retrofit.create(CommentService::class.java)
    }
}