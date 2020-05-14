package dev.chu.architecture.java.p80.sub_component;

import dagger.Module;
import dagger.Provides;

@Module
public class MachineModule {

    @Provides
    CoffeeBean provideCoffeeBean() {
        return new CoffeeBean();
    }

}
