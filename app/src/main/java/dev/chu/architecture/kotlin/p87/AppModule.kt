package dev.chu.architecture.kotlin.p87

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dev.chu.architecture.App
import javax.inject.Singleton

@Module(subcomponents = [MainActivityComponent::class])
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: App): SharedPreferences {
        return app.getSharedPreferences("default", Context.MODE_PRIVATE)
    }
}
