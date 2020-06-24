package kr.co.coroutine_retrofit_dagger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kr.co.coroutine_retrofit_dagger.di.DaggerAppComponent

class MainApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}