package dev.chu.architecture.kotlin.p87_sample

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [K_AppModule::class])
@Singleton
interface K_AppComponent {

    var sampleActivityFactory: SampleActivityComponent.Factory

    fun inject(app: K_App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: K_App, appModule: K_AppModule): K_AppComponent
    }

}