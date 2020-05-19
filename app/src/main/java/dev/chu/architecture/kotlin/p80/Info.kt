package dev.chu.architecture.kotlin.p80

import javax.inject.Inject

class CoffeeMachine(factory: MachineCoffeeComponent.Factory) {
    private val component: MachineCoffeeComponent = factory.create(MachineCoffeeModule())

    init {
        component.inject(this)
    }

    fun extract(): Coffee = component.getCoffee()
}


class Coffee @Inject constructor(coffeeBean: CoffeeBean, water: Water) {
    init {
        println("new Make coffee")
    }
}

class CoffeeBean {
    init {
        println("new CoffeeBean")
    }
}

class Water {
    init {
        println("new Water")
    }
}

class MixerMachine(factory: MachineMixerComponent.Factory) {
    private val component: MachineMixerComponent = factory.create(MachineMixerModule())

    init {
        component.inject(this)
    }

    fun extract(): Ade = component.getAde()
}

class Ade @Inject constructor(fruit: Fruit, water: Water) {
    init {
        println("new Make ade")
    }
}

class Fruit {
    init {
        println("new Fruit")
    }
}