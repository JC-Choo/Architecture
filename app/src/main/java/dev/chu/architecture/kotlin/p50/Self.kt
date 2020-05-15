package dev.chu.architecture.kotlin.p50

import dev.chu.architecture.java.B
import javax.inject.Inject

open class Self : Parent() {
    @JvmField
    @Inject
    var b: B? = null
}