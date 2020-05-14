package dev.chu.architecture.kotlin.p87_sample

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [SampleActivityModule::class])
interface SampleActivityComponent {

    fun inject(activity: SampleActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: SampleActivity): SampleActivityComponent
    }

}
