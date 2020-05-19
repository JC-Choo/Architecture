package dev.chu.architecture.kotlin.p67

import javax.inject.Inject

class Foo {
    @Inject
    lateinit var strings: Set<String>

    fun print() {
        val itr: Iterator<*> = strings.iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }
    }
}