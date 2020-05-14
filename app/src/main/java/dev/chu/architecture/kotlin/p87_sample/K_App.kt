package dev.chu.architecture.kotlin.p87_sample

import android.app.Application

class K_App : Application() {
    private lateinit var appComponent: K_AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerK_AppComponent.factory()
            .create(this, K_AppModule())
    }

    fun getK_AppComponent(): K_AppComponent = appComponent
}