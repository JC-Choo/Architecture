package dev.chu.architecture.kotlin.p54

import dagger.Component

@Component(modules = [CounterModule::class])
interface CounterComponent {
    fun inject(counter: Counter)
}