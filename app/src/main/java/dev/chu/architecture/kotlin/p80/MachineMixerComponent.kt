package dev.chu.architecture.kotlin.p80

import dagger.Subcomponent

@Subcomponent(modules = [MachineMixerModule::class])
interface MachineMixerComponent {

    fun getAde(): Ade
    fun inject(mixer: MixerMachine)

    @Subcomponent.Factory
    interface Factory {
        fun create(module: MachineMixerModule): MachineMixerComponent
    }
}