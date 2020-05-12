package dev.chu.architecture.kotlin

import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getString(): String
}