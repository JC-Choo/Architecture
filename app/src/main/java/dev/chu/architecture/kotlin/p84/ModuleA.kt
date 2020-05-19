package dev.chu.architecture.kotlin.p84

import dagger.Module
import dagger.Provides

@Module
class ModuleA {
    @Provides
    fun provideString() = "String from ModuleA"
}