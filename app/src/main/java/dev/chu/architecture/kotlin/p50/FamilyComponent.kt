package dev.chu.architecture.kotlin.p50

import dagger.Component

@Component(modules = [FamilyModule::class])
interface FamilyComponent {

    fun inject(clz: Self)    // 멤버-인젝션 메서드

}