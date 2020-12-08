package dev.chu.architecture.kotlin.p50

import javax.inject.Inject

class Child : Self() {
    @JvmField
    @Inject
    var c: C? = null
}