package dev.chu.architecture;

import org.junit.Test;

import dev.chu.architecture.kotlin.p80.Cafe;

public class ExampleUnitTestJava {

    @Test
    public void testCafe() {
        Cafe cafe = new Cafe();
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
    }

//    @Test
//    public void testHelloWorld() {
//
////        MyComponent myComponent = DaggerMyComponent.builder().build();
//        MyComponent myComponent = DaggerMyComponent.create();
////        System.out.println("java : result = "+myComponent.getString());
////        System.out.println("java : result = "+myComponent.getAge());
////        System.out.println("java : result = "+myComponent.getPerson());
////        System.out.println("java : result = "+myComponent.getA());
////        System.out.println("java : result = "+myComponent.getB());
//
//        MyClass myClass1 = new MyClass();
//        String str = myClass1.getStr();
//        assertNull("조회 결과 null", str);   // null이 아님을 확인
//
//        MembersInjector<MyClass> injector = myComponent.getInjector();
//        injector.injectMembers(myClass1);
//        str = myClass1.getStr();
////        System.out.println("str = "+str);
//        assertEquals("hello world", str);   // str = "hello world"
//
////        MyClass myClass2 = new MyClass();
////        int age = myClass2.getAge();
////        System.out.println("age = "+age);
////        assertNotNull("조회 결과 not null", age);   // null이 아님을 확인
////        myComponent.inject(myClass2);
////        age = myClass2.getAge();
////        System.out.println("age = "+age);
////        assertEquals(100, age);   // str = "hello world"
//
//    }
}
