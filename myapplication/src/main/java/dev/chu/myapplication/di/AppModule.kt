package dev.chu.myapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dev.chu.myapplication.App
import dev.chu.myapplication.util.SingleLiveEvent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RetrofitModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideApp(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(app: App): Context {
        return app
    }

    // 앱의 오류 이벤트를 처리하는 SingleLiveEvent
    @Singleton
    @Provides
    @Named("errorEvent")
    fun provideErrorEvent(): SingleLiveEvent<Throwable> {
        return SingleLiveEvent()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}