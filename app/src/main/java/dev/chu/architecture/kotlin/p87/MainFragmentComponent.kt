package dev.chu.architecture.kotlin.p87

import dagger.BindsInstance
import dagger.Subcomponent
import dev.chu.architecture.etc.FragmentScope

@Subcomponent(modules = [MainFragmentModule::class])
@FragmentScope
interface MainFragmentComponent {
    fun inject(fragment: MainFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            module: MainFragmentModule,
            @BindsInstance fragment: MainFragment
        ): MainFragmentComponent
    }
}
