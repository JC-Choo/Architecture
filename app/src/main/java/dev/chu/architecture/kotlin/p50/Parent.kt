package dev.chu.architecture.kotlin.p50

import javax.inject.Inject

open class Parent {
    @JvmField
    @Inject
    var a: A? = null
}