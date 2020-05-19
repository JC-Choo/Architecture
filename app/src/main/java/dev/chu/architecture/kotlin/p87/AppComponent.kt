package dev.chu.architecture.kotlin.p87

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.chu.architecture.App
import javax.inject.Singleton

//@Component(modules = [AppModule::class])
//@Singleton
//interface AppComponent {
//    fun mainActivityComponentFactory(): MainActivityComponent.Factory
//    fun inject(app: App)    // 멤버-인젝션 메서드 : @Inject 필드들에게 인젝션을 넣어주기 위한 메서드
//
//    @Component.Factory
//    interface Factory {
//        fun create(
//            @BindsInstance app: App,    // @BindsInstance : 외부에서 생성된 인스턴스를 가져와 컴포넌트가 해당 인스턴스를 바인드 하기 위한 애노테이션
//            module: AppModule
//        ): AppComponent
//    }
//}

// 보일러 플레이트 코드 제거

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}