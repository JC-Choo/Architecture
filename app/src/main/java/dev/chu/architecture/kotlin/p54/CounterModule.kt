package dev.chu.architecture.kotlin.p54

import dagger.Module
import dagger.Provides

@Module
class CounterModule {
    var next = 100
    @Provides
    fun provideInteger(): Int {
        println("Computing...")
        return next++
    }
}
