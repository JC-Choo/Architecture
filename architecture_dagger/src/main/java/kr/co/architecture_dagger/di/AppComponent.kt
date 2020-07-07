package kr.co.architecture_dagger.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kr.co.architecture_dagger.MainApplication
import javax.inject.Singleton

/**
 * 안드로이드 애플리케이션 컴포넌트 정의
 * - [AndroidSupportInjectionModule] : dagger.android 사용을 위한 설정
 * - [AppModule] : 애플리케이션 스코프 모듈
 * - [ActivityModule] : 액티비티 스코프 모듈
 * - 안드로이드 애플리케이션 컴포넌트 팩토리 정의 : [Component.Factory]
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)
abstract class AppComponent : AndroidInjector<MainApplication> {
    // 안드로이드 애플리케이션 컴포넌트 팩토리 정의
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MainApplication>
}