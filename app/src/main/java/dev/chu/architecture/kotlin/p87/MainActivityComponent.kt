package dev.chu.architecture.kotlin.p87

import dagger.BindsInstance
import dagger.Subcomponent
import dev.chu.architecture.etc.ActivityScope

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {
    fun mainFragmentFactory(): MainFragmentComponent.Factory
    fun inject(activity: MainActivity)

    // 액티비티 인스턴스는
    @Subcomponent.Factory
    interface Factory {
        fun create(
            module: MainActivityModule,
            @BindsInstance activity: MainActivity
        ): MainActivityComponent
    }
}
