//package dev.chu.architecture.java.p80.component;
//
//import javax.inject.Inject;
//
//import dev.chu.architecture.java.p80.sub_component.Coffee;
//import dev.chu.architecture.java.p80.sub_component.Machine;
//
//public class Cafe {
//
//    @Inject
//    Machine coffeeMachine;
//
//    public Cafe() {
//        DaggerCafeComponent.create().inject(this);
//    }
//
//    public Coffee orderCoffee() {
//        return coffeeMachine.extract();
//    }
//}
