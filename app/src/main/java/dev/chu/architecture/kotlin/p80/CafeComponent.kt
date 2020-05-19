package dev.chu.architecture.kotlin.p80

import dagger.Component

@Component(modules = [CafeModule::class])
interface CafeComponent {
    fun inject(cafe: Cafe)
}