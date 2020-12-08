package dev.chu.architecture.kotlin.p74

import dagger.Subcomponent

@Subcomponent(modules = [ChildModule::class])
interface ChildComponent {
    fun strigns(): Set<String>

    @Subcomponent.Builder
    interface Builder {
        fun build(): ChildComponent
    }

}
