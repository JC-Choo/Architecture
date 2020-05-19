package dev.chu.architecture.kotlin.p71

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class MapModule {
    @IntoMap
    @AnimalKey(Animal.CAT)
    @Provides
    fun provideCat(): String = "Meow"

    @IntoMap
    @AnimalKey(Animal.DOG)
    @Provides
    fun provideDog(): String = "Bow-wow"

    @IntoMap
    @NumberKey(Float::class)
    @Provides
    fun provideFloatValue(): String = "100f"

    @IntoMap
    @NumberKey(Int::class)
    @Provides
    fun provideIntValue(): String = "1"
}
