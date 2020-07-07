package kr.co.architecture_dagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.architecture_dagger.ui.MainActivity

/**
 * MainActivity 를 위한 서브 컴포넌트를 정의
 * - [ActivityScope] : Activity 용 scope
 */

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
}
