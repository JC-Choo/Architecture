package dev.chu.architecture.kotlin.p54

import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

class Counter {

//    @Inject
//    lateinit var lazy: Lazy<Int>
//
//    fun printLazy() {
//        println("Printing...")
//        println(lazy.get())
//        println(lazy.get())
//        println(lazy.get())
//    }


    @Inject
    lateinit var provider: Provider<Int>

    fun printProvider() {
        println("Printing...")
        println(provider.get())
        println(provider.get())
        println(provider.get())
    }
}
