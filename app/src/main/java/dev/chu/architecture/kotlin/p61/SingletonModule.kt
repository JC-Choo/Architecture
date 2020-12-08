package dev.chu.architecture.kotlin.p61

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SingletonModule {
    @Provides
    @Singleton
    fun provideAny(): Any {
        return Any()
    }
}