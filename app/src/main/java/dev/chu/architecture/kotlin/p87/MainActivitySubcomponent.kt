package dev.chu.architecture.kotlin.p87

import dagger.Subcomponent
import dagger.android.AndroidInjector
import dev.chu.architecture.etc.ActivityScope

// 보일러 플레이트 코드 제거

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory: AndroidInjector.Factory<MainActivity>
}
