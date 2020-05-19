package dev.chu.architecture.kotlin.p80

import dagger.Subcomponent

@Subcomponent(modules = [MachineCoffeeModule::class])
interface MachineCoffeeComponent {

    fun getCoffee(): Coffee
    fun inject(machine: CoffeeMachine)

    @Subcomponent.Factory
    interface Factory {
        fun create(module: MachineCoffeeModule): MachineCoffeeComponent
    }
}
