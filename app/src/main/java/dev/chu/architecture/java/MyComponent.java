package dev.chu.architecture.java;

import dagger.Component;
import dagger.MembersInjector;
import dev.chu.architecture.entity.Person;

@Component(modules = MyModule.class)
//@Component(modules = {MyModule.class, ModuleB.class})
public interface MyComponent {

    String getString(); // 프로비전 메서드, 바인드된 모듈로부터 의존성을 제공
    Integer getAge();
    Person getPerson();

//    A getA();
//    B getB();   // ModuleB.class 를 가져올 경우는 상속에 의해 B는 사용 불가하다.

//    void inject(MyClass myClass);

    MembersInjector<MyClass> getInjector();
}
