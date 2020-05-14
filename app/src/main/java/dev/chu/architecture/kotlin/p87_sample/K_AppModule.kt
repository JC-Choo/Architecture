package dev.chu.architecture.kotlin.p87_sample

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [SampleActivityComponent::class])
class K_AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: K_App): SharedPreferences {
        return app.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

}
