package dev.chu.architecture.kotlin.p80

import javax.inject.Inject

class Cafe {

    @Inject
    lateinit var water: Water
    @Inject
    lateinit var coffeeMachine: CoffeeMachine
    @Inject
    lateinit var mixerMachine: MixerMachine

    init {
        DaggerCafeComponent.create().inject(this)
    }

    fun orderCoffee() = coffeeMachine.extract()
    fun orderAde() = mixerMachine.extract()
}
