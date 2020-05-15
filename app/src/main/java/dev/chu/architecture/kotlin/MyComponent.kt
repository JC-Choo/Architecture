package dev.chu.architecture.kotlin

import androidx.annotation.Nullable
import dagger.Component
import dev.chu.architecture.entity.Person

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getName(): String
    @Nullable
    fun getAge(): Int?
    fun getPerson(): Person
//    fun getDouble(): Double
}