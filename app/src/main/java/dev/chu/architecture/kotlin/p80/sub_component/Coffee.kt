package dev.chu.architecture.kotlin.p80.sub_component

import javax.inject.Inject

class Coffee @Inject constructor(private val coffeeBean: CoffeeBean, private val water: Water){
    init {
        println("Coffee - coffeeBean = $coffeeBean, water = $water")
    }
}
