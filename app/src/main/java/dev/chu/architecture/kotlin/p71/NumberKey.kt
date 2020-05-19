package dev.chu.architecture.kotlin.p71

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class NumberKey(val value: KClass<out Number>)