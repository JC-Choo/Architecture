package dev.chu.architecture.kotlin.p87

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.chu.architecture.etc.ActivityScope
import dev.chu.architecture.etc.FragmentScope
import dev.chu.architecture.kotlin.p87.MainFragmentComponent
import javax.inject.Named

//@Module(subcomponents = [MainFragmentComponent::class])
//class MainActivityModule {
//    @Provides
//    @ActivityScope
//    fun provideActivityName(): String = MainActivity::class.java.simpleName
//}

// 2. 보일러 플레이트 코드 제거

//@Module(subcomponents = [MainFragmentSubcomponent::class])
//abstract class MainActivityModule {
//    companion object {
//        @Named("activity")
//        @Provides
//        @ActivityScope
//        fun provideString(): String = "String from MainActivityModule"
//    }
//
//    @Binds
//    @IntoMap
//    @ClassKey(MainFragment::class)
//    abstract fun bindInjectorFactory(factory: MainFragmentSubcomponent.Factory): AndroidInjector.Factory<*>
//}

// 3. @ContributesAndroidInjector 애노테이션 활용

@Module
abstract class MainActivityModule {
    companion object {
        @Named("activity")
        @Provides
        @ActivityScope
        fun provideString(): String = "String from MainActivityModule"
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}