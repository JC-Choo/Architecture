package dev.chu.architecture.java.p87;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dev.chu.architecture.App;
import dev.chu.architecture.etc.ActivityScope;

//@Module(subcomponents = MainActivityComponent.class)
//public class AppModule {
//
//    @Provides
//    @Singleton
//    SharedPreferences provideSharedPreferences(App app) {
//        return app.getSharedPreferences("default", Context.MODE_PRIVATE);
//    }
//
//}

// 1. 보일러 플레이트 코드 제거
// MainActivitySubcomponent : MainActivity의 인스턴스에 멤버 인젝션을 담당

//@Module(subcomponents = MainActivitySubcomponent.class)
//public abstract class AppModule {
//
//    @Named("app")
//    @Provides
//    @Singleton
//    static String provideString() {
//        return "String from AppModule";
//    }
//
//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity.class)
//    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivitySubcomponent.Factory factory);
//    // bindAndroidInjectorFactory : AndroidInjectionModule 내부에 있는 Map에 AndroidInjector.Factory를 멀티 바인딩 한다.
//    // -> 이를 통해 서브 컴포넌트들이 편하게 멤버 인젝션을 할 수 있도록 인젝터 팩토리들을 멀티 바인딩으로 관리.
//
//}

// 2. ContributesAndroidInjector 사용
// subComponent의 팩토리가 "다른 method or class 를 상속하지 않을 때" 사용
// -> subComponent를 정의하는 코드를 대체
// -> subComponent를 위한 보일러 플레이트 코드 줄이는 효과

@Module
public abstract class AppModule {

    @Named("app")
    @Provides
    @Singleton
    static String provideString() {
        return "String from AppModule";
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

}
