package dev.chu.architecture.java.p87;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dev.chu.architecture.etc.ActivityScope;
import dev.chu.architecture.etc.FragmentScope;

//@Module(subcomponents = MainFragmentComponent.class)
//public class MainActivityModule {
//
//    @Provides
//    @ActivityScope
//    public String provideActivityName() {
//        return MainActivity.class.getSimpleName();
//    }
//
//}

// 1. 보일러 플레이트 코드 제거
// MainFragment에 멤버 인젝션을 하기 위해 MainFragmentSubcomponent를 연결

//@Module(subcomponents = MainFragmentSubcomponent.class)
//public abstract class MainActivityModule {
//
//    // @ActivityScope 에서 문자열을 제공하는 프로바이드 메서드
//    @Named("activity")
//    @Provides
//    @ActivityScope
//    static String provideString() {
//        return "String from MainActivityModule";
//    }
//
//    // MainFragment를 위한 인젝터 팩토리를 멀티 바인딩한다.
//    @Binds
//    @IntoMap
//    @ClassKey(MainFragment.class)
//    abstract AndroidInjector.Factory<?> bindInjectorFactory(MainFragmentSubcomponent.Factory factory);
//
//}

// 2. ContributesAndroidInjector 사용

@Module
public abstract class MainActivityModule {

    @Named("activity")
    @Provides
    @ActivityScope
    static String provideString() {
        return "String from MainActivityModule";
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragment();
}