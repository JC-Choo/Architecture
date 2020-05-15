package dev.chu.architecture.kotlin.p50

import dev.chu.architecture.java.C
import javax.inject.Inject

class Child : Self() {
    @JvmField
    @Inject
    var c: C? = null
}