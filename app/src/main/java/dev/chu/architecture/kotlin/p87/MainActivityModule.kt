package dev.chu.architecture.kotlin.p87

import dagger.Module
import dagger.Provides
import dev.chu.architecture.etc.ActivityScope

@Module(subcomponents = [MainFragmentComponent::class])
class MainActivityModule {
    @Provides
    @ActivityScope
    fun provideActivityName(): String = MainActivity::class.java.simpleName
}
