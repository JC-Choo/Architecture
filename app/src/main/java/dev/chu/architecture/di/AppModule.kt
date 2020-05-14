//package dev.chu.architecture.di
//
//import android.content.Context
//import android.content.SharedPreferences
//import dagger.Module
//import dagger.Provides
//import dev.chu.architecture.App
//import javax.inject.Singleton
//
//@Module(subcomponents = [ActivityComponent::class])
//class AppModule {
//
//    @Provides
//    @Singleton
//    fun provideSharedPreferences(app: App): SharedPreferences =
//        app.getSharedPreferences("default", Context.MODE_PRIVATE)
//
//}