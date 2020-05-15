package dev.chu.architecture.kotlin.p47

import dagger.Module
import dagger.Provides

@Module
class PersonModule {

    @Provides
    fun provideName(): String = "Chu"

    @Provides
    fun provideAge(): Int = 100
}
