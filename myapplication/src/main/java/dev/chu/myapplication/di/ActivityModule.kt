package dev.chu.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.chu.myapplication.ui.MainActivity
import dev.chu.myapplication.ui.MainModule

@Module
abstract class ActivityModule {
    // MainActivity 를 위한 서브 컴포넌트를 정의
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}