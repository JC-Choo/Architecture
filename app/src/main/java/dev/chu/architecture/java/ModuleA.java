package dev.chu.architecture.java;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA {
    @Provides
    A provideA() {
        return new A();
    }
}
