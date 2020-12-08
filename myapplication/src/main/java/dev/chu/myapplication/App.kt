package dev.chu.myapplication

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.chu.myapplication.di.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        // 로그용 Timber 설정
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        // AppComponent 설정이 끝난 뒤, 컴파일 타임에 DaggerAppComponent 가 생성된다.
        return DaggerAppComponent.factory().create(this)
    }

}