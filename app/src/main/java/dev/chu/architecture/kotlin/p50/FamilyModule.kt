package dev.chu.architecture.kotlin.p50

import dagger.Module
import dagger.Provides

@Module
class FamilyModule {

    @Provides
    fun provideA(): A = A()

    @Provides
    fun provideB(): B = B()

    @Provides
    fun provideC(): C = C()

}

class A() {
    init {
        println("A class")
    }
}
class B() {
    init {
        println("B class")
    }
}
class C() {
    init {
        println("C class")
    }
}