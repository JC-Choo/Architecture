package dev.chu.architecture.java;

import dagger.Module;
import dagger.Provides;
import dev.chu.architecture.entity.Person;

@Module
public class MyModule {

    @Provides
    String provideHelloWorld() {
        return "hello world";
    }

    @Provides
    Integer provideAge() {
        return 100;
    }

    @Provides
    Person providePerson(String name, int age) {
        return new Person(name, age);
    }

}
