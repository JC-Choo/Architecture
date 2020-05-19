package dev.chu.architecture.kotlin.p84

import dagger.Module
import dagger.Provides

@Module
class ModuleB {
    @Provides
    fun provideInt() = 100
}