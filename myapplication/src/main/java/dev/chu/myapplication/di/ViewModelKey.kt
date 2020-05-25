package dev.chu.myapplication.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import kotlin.reflect.KClass

//@Documented
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

// KCall : If you need to specify a class as an argument of an annotation, use a Kotlin class (KClass).
// The Kotlin compiler will automatically convert it to a Java class,
// so that the Java code can access the annotations and arguments normally.