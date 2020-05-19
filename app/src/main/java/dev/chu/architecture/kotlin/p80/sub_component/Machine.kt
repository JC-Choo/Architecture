package dev.chu.architecture.kotlin.p80.sub_component

class Machine(builder: MachineComponent.Builder) {

    private var component: MachineComponent = builder.setMachineModule(MachineModule())
        .build()

    init {
        component.inject(this)
    }

    fun extract(): Coffee = component.getCoffee()
}
