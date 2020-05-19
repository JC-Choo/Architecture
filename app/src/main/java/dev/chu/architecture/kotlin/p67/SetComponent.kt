package dev.chu.architecture.kotlin.p67

import dagger.Component

@Component(modules = [SetModule::class])
interface SetComponent {
    fun inject(foo: Foo)
}