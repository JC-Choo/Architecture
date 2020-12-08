package dev.chu.architecture.kotlin.p84

import dagger.Component

@Component(modules = [ModuleA::class])
interface ComponentA {
    fun provideString(): String // 프로비전 메서드
}