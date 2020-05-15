package dev.chu.architecture.kotlin.p50

import dev.chu.architecture.java.A
import javax.inject.Inject

open class Parent {
    @JvmField
    @Inject
    var a: A? = null
}