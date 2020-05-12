package dev.chu.architecture.java;

import javax.inject.Inject;

public class MyClass {
    @Inject
    String str;

    public String getStr() {
        return str;
    }

    @Inject
    int age;
    public int getAge() {
        return age;
    }
}
