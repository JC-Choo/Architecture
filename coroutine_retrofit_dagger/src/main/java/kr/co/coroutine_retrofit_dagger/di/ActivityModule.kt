package kr.co.coroutine_retrofit_dagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.coroutine_retrofit_dagger.ui.main.MainActivity
import kr.co.coroutine_retrofit_dagger.ui.main.di.MainModule

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}
