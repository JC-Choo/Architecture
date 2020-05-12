package dev.chu.architecture

import dev.chu.architecture.java.PersonB
import dev.chu.architecture.kotlin.DaggerMyComponent
import dev.chu.architecture.kotlin.DaggerPersonComponent
import org.junit.Assert.assertEquals
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
//        println("kotlin : result = " + myComponent.getString())

        val personComponent = DaggerPersonComponent.create()
        val personA = personComponent.getPersonA()
        println(personA.name + " : "+ personA.age)

        val personB = PersonB()
        personComponent.inject(personB)
        assertEquals("Chu", personB.name)
        assertEquals(100, personB.age)
    }
}
