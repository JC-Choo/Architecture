//package dev.chu.architecture.java.p80.sub_component;
//
//public class Machine {
//
//    private MachineComponent component;
//
//    public Machine(MachineComponent.Builder builder) {
//        component = builder.setMachineModule(new MachineModule())
//                .build();
//        component.inject(this);
//    }
//
//    public Coffee extract() {
//        return component.getCoffee();
//    }
//
//}
