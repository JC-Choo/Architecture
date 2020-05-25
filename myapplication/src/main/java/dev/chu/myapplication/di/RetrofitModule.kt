package dev.chu.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dev.chu.myapplication.data.CommentService
import dev.chu.myapplication.data.PostService
import dev.chu.myapplication.data.UserService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

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