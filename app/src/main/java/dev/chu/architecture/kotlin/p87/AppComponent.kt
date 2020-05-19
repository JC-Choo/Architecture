package dev.chu.architecture.kotlin.p87

import dagger.BindsInstance
import dagger.Component
import dev.chu.architecture.App
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun mainActivityComponentFactory(): MainActivityComponent.Factory
    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App,
            module: AppModule
        ): AppComponent
    }
}