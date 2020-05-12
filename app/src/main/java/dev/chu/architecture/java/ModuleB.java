package dev.chu.architecture.java;

import dagger.Module;
import dagger.Provides;

@Module(includes = ModuleA.class)
class ModuleB {
    @Provides
    B provideB() {
        return new B();
    }
}
