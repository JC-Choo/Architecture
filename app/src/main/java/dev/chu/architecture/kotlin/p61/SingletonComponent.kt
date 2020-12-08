package dev.chu.architecture.kotlin.p61

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SingletonModule::class])
interface SingletonComponent {
    fun getAny(): Any
}