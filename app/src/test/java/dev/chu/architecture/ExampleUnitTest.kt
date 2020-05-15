package dev.chu.architecture

import dev.chu.architecture.kotlin.p50.DaggerFamilyComponent
import dev.chu.architecture.kotlin.p50.Self
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val myComponent = DaggerMyComponent.builder().build()
//        val myComponent = DaggerMyComponent.create()
//        println("kotlin : result = " + myComponent.getName())
//        println("kotlin : result = " + myComponent.getAge())
//        println("kotlin : result = " + myComponent.getPerson())

//        println("kotlin : result = " + myComponent.getString())
//        println("kotlin : result = " + myComponent.getDouble())

//        val myClass = MyClass()
//        var str = myClass.str
//        assertNotNull("조회 결과 null", str)
//        myComponent.inject(myClass)
//        str = myClass.str
//        assertEquals("Chu", str)


//        val personComponent = DaggerPersonComponent.create()
//
//        val personA = personComponent.getPersonA
//        println(personA.name + " : "+ personA.age)
//
//        val personB = PersonB()
//        personComponent.inject(personB)
//        assertEquals("Chu", personB.name)
//        assertEquals(100, personB.age)


        val component = DaggerFamilyComponent.create()

        val b = Self()

//        component.inject(a)
        component.inject(b)
//        component.inject(c)
    }
}
