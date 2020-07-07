package kr.co.architecture_dagger.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kr.co.architecture_dagger.MainApplication
import kr.co.architecture_dagger.data.Api
import kr.co.architecture_dagger.data.ApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class AppModule {
    @Provides
    @Singleton
    fun provideApp(app: MainApplication): Application = app

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(app: MainApplication): Context = app

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Api.createService(ApiService::class.java)
}
