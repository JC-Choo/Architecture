package dev.chu.architecture.kotlin.p80.component

import dev.chu.architecture.kotlin.p80.sub_component.Machine
import javax.inject.Inject

class Cafe @Inject constructor(){
    init {
        println("Cafe")
        DaggerCafeComponent.create().inject(this)
    }

    @Inject
    @JvmField
    var coffeeMachine: Machine? = null

    fun orderCoffee() = coffeeMachine?.extract()
}