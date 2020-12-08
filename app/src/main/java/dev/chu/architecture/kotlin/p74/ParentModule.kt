package dev.chu.architecture.kotlin.p74

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module(subcomponents = [ChildComponent::class])
class ParentModule {
    @Provides
    @IntoSet
    fun string1(): String = "parent string 1"

    @Provides
    @IntoSet
    fun string2(): String = "parent string 2"
}
