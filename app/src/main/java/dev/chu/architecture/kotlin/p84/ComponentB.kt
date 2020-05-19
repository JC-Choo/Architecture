package dev.chu.architecture.kotlin.p84

import dagger.Component

// ComponentA를 상속
@Component(modules = [ModuleB::class], dependencies = [ComponentA::class])
interface ComponentB {
    fun inject(foo: Foo)
}