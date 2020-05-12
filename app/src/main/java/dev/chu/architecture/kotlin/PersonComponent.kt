package dev.chu.architecture.kotlin

import dagger.Component
import dev.chu.architecture.java.PersonA
import dev.chu.architecture.java.PersonB

@Component(modules = [PersonModule::class])
interface PersonComponent {

    fun getPersonA(): PersonA   // 프로비젼 메소드

    fun inject(personB: PersonB)    // 멤버-인젝션 메소드

}