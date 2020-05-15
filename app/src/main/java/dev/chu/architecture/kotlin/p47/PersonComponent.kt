package dev.chu.architecture.kotlin.p47

import dagger.Component

@Component(modules = [PersonModule::class])
interface PersonComponent {
    var getPersonA: PersonA         // 프로비전 메서드
    fun inject(personB: PersonB)    // 멤버-인젝션 메서드
}