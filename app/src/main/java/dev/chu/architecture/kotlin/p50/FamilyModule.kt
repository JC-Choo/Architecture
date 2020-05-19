package dev.chu.architecture.kotlin.p50

import dagger.Module
import dagger.Provides
import dev.chu.architecture.java.A
import dev.chu.architecture.java.B
import dev.chu.architecture.java.C

@Module
class FamilyModule {

    @Provides
    fun provideA(): A = A()

    @Provides
    fun provideB(): B = B()

    @Provides
    fun provideC(): C = C()

}
