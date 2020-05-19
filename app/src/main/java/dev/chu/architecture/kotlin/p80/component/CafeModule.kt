//package dev.chu.architecture.kotlin.p80.component
//
//import dagger.Module
//import dagger.Provides
//import dev.chu.architecture.kotlin.p80.sub_component.Machine
//import dev.chu.architecture.kotlin.p80.sub_component.MachineComponent
//import dev.chu.architecture.kotlin.p80.sub_component.Water
//
//@Module(subcomponents = [MachineComponent::class])
//class CafeModule {
//    @Provides
//    fun provideWater(): Water = Water()
//
//    @Provides
//    fun provideMachine(builder: MachineComponent.Builder): Machine = Machine(builder)
//}
