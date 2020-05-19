package dev.chu.architecture

import dev.chu.architecture.kotlin.p50.Child
import dev.chu.architecture.kotlin.p50.DaggerFamilyComponent
import dev.chu.architecture.kotlin.p50.Self
import dev.chu.architecture.kotlin.p54.Counter
import dev.chu.architecture.kotlin.p54.DaggerCounterComponent
import dev.chu.architecture.kotlin.p61.DaggerSingletonComponent
import dev.chu.architecture.kotlin.p67.DaggerSetComponent
import dev.chu.architecture.kotlin.p67.Foo
import dev.chu.architecture.kotlin.p71.Animal
import dev.chu.architecture.kotlin.p71.DaggerMapKeyComponent
import dev.chu.architecture.kotlin.p74.DaggerParentComponent
import dev.chu.architecture.kotlin.p80.Cafe
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertSame
import org.junit.Assert
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testCafe() {
        val cafe = Cafe()
        println(cafe.orderCoffee())
        println(cafe.orderCoffee())
        println(cafe.orderCoffee())
        println(cafe.orderAde())
        println(cafe.orderAde())
        println(cafe.orderAde())
    }

    @Test
    fun testMultiBindingWithSubComponent() {
        val parentComp = DaggerParentComponent.create()
        val childComp = parentComp.childCompBuilder().build()
        println("List set in Parent")

        var itr = parentComp.strings().iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }

        println("List set in Child")

        itr = childComp.strigns().iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }
    }

    @Test
    fun testMap() {
        val component = DaggerMapKeyComponent.create()
        val cat = component.getStringsByAnimal()[Animal.CAT]
        val dog = component.getStringsByAnimal()[Animal.DOG]
        val number = component.getStringsByNumber()[Float::class.java]

        println(cat)
        println(dog)
        println(number)

        Assert.assertEquals("Meow", cat)
        Assert.assertEquals("Bow-wow", dog)
        Assert.assertEquals("100f", number)
    }

    @Test
    fun testSet() {
        val foo = Foo()
        DaggerSetComponent.create().inject(foo)
        foo.print()
    }

    @Test
    fun testSingleton() {
        val component = DaggerSingletonComponent.create()
        val temp1 = component.getAny()
        val temp2 = component.getAny()
        assertNotNull(temp1)
        assertNotNull(temp2)
        assertSame(temp1, temp2)
    }

    @Test
    fun testLazy() {
        val component = DaggerCounterComponent.create()
        val counter = Counter()
        component.inject(counter)
        counter.printProvider()
    }

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
        val clz = Child()
        component.inject(clz)
        val clz2 = Self()
        component.inject(clz2)
    }
}
