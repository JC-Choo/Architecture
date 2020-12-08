package dev.chu.architecture.kotlin.p74

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ChildModule {
    @Provides
    @IntoSet
    fun string3(): String = "child string 1"

    @Provides
    @IntoSet
    fun string4(): String = "child string 2"

}
