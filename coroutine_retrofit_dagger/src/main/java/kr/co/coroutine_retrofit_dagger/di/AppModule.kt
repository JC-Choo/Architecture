package kr.co.coroutine_retrofit_dagger.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kr.co.coroutine_retrofit_dagger.MainApplication
import kr.co.coroutine_retrofit_dagger.data.di.RetrofitModule
import javax.inject.Singleton

@Module(
    includes = [
        ViewModelModule::class,
        RetrofitModule::class
    ]
)
class AppModule {
    @Provides
    @Singleton
    fun provideMainApplication(application: MainApplication): MainApplication = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: MainApplication): Context = application
}
