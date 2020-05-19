package dev.chu.architecture.kotlin.p84

import javax.inject.Inject

class Foo {
    @Inject
    lateinit var str: String

    @Inject
    @JvmField
    var integer: Int = 0
}