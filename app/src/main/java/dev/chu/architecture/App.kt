package dev.chu.architecture

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dev.chu.architecture.kotlin.p87.AppComponent
import dev.chu.architecture.kotlin.p87.AppModule
import dev.chu.architecture.kotlin.p87.DaggerAppComponent
import javax.inject.Inject

//class App : Application() {
//    private lateinit var appComponent: AppComponent
//
//    override fun onCreate() {
//        super.onCreate()
//
//        appComponent = DaggerAppComponent.factory()
//            .create(this, AppModule()).apply {
//                inject(this@App)
//            }
//    }
//
//    fun getAppComponent() = appComponent
//}

// 2. 보일러 플레이트 코드 제거

//class App : Application(), HasAndroidInjector {
//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
//
//    override fun onCreate() {
//        super.onCreate()
//        DaggerAppComponent.factory()
//            .create(this)
//            .inject(this)
//    }
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return dispatchingAndroidInjector
//    }
//}

// 3. @ContributesAndroidInjector 애노테이션 활용

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}