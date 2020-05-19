package dev.chu.architecture.kotlin.p87

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.chu.architecture.etc.FragmentScope

// 보일러 플레이트 제거

@Subcomponent(modules = [MainFragmentModule::class])
@FragmentScope
interface MainFragmentSubcomponent: AndroidInjector<MainFragment> {

    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainFragment>

}
