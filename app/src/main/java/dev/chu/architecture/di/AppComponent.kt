//package dev.chu.architecture.di
//
//import dagger.BindsInstance
//import dagger.Component
//import dev.chu.architecture.App
//import javax.inject.Singleton
//
//@Component(modules = [AppModule::class])
//@Singleton
//interface AppComponent {
//
//    var activityComponentBuilder: ActivityComponent.Builder
//
//    fun inject(app: App)
//
//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance app: App, appModule: AppModule): AppComponent
//    }
//
//}