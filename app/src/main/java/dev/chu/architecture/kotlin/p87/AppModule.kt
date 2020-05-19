package dev.chu.architecture.kotlin.p87

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.chu.architecture.App
import dev.chu.architecture.etc.ActivityScope
import dev.chu.architecture.kotlin.p87.MainActivityComponent
import javax.inject.Named
import javax.inject.Singleton

//@Module(subcomponents = [MainActivityComponent::class])
//class AppModule {
//    @Provides
//    @Singleton
//    fun provideSharedPreferences(app: App): SharedPreferences {
//        return app.getSharedPreferences("default", Context.MODE_PRIVATE)
//    }
//}

// 2. 보일러 플레이트 코드 제거

//// MainActivity의 인스턴스에 멤버 인젝션을 담당할 MainActivitySubcomponent를 서브 컴포넌트로 연결.
//@Module(subcomponents = [MainActivitySubcomponent::class])
//abstract class AppModule {
//    companion object {
//        @Named("app")
//        @Provides
//        @Singleton
//        fun provideString() = "String from AppModule"
//    }
//
//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity::class)
//    abstract fun bindAndroidInjectorFactory(factory: MainActivitySubcomponent.Factory): AndroidInjector.Factory<*>
//    // AndroidInjectionModule 내부에 있는 Map 에 AndroidInjector.Factory 를 멀티 바인딩 하기 위함.
//}

// 3. @ContributesAndroidInjector 애노테이션 활용

@Module
abstract class AppModule {
    companion object {
        @Named("app")
        @Provides
        @Singleton
        fun provideString() = "String from AppModule"
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}