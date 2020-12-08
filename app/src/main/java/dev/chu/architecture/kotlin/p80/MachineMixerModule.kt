package dev.chu.architecture.kotlin.p80

import dagger.Module
import dagger.Provides

@Module
class MachineMixerModule {
    @Provides
    fun provideFruit() = Fruit()
}
