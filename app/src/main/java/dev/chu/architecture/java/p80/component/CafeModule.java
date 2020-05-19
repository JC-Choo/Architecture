//package dev.chu.architecture.java.p80.component;
//
//import dagger.Module;
//import dagger.Provides;
//import dev.chu.architecture.java.p80.sub_component.Machine;
//import dev.chu.architecture.java.p80.sub_component.MachineComponent;
//import dev.chu.architecture.java.p80.sub_component.Water;
//
//@Module(subcomponents = MachineComponent.class)
//class CafeModule {
//
//    @Provides
//    Water provideWater() {
//        return new Water();
//    }
//
//    @Provides
//    Machine provideMachine(MachineComponent.Builder builder) {
//        return new Machine(builder);
//    }
//
//}
