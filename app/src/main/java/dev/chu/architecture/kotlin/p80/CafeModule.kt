package dev.chu.architecture.kotlin.p80

import dagger.Module
import dagger.Provides

@Module(subcomponents = [MachineCoffeeComponent::class, MachineMixerComponent::class])
class CafeModule {
    @Provides
    fun provideWater(): Water = Water()

    @Provides
    fun provideMachine(factory: MachineCoffeeComponent.Factory): CoffeeMachine = CoffeeMachine(factory)

    @Provides
    fun provideMixer(factory: MachineMixerComponent.Factory): MixerMachine = MixerMachine(factory)
}
