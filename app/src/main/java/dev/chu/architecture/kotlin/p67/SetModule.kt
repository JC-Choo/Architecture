package dev.chu.architecture.kotlin.p67

import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
class SetModule {
    @Provides
    @IntoSet
    fun provideHello() = "Hello"

    @Provides
    @IntoSet
    fun provideWorld() = "World"

    @Provides
    @ElementsIntoSet
    fun provideSet(): Set<String> = HashSet<String>(listOf("Chu", "Chu100"))
}