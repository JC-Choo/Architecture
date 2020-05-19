package dev.chu.architecture.kotlin.p80.sub_component

import dagger.Module
import dagger.Provides

@Module
class MachineModule {

    @Provides
    fun provideCoffeeBean() = CoffeeBean()
}