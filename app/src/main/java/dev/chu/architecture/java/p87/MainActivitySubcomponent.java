package dev.chu.architecture.java.p87;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dev.chu.architecture.etc.ActivityScope;

// 1. 보일러 플레이트 코드 제거
// MainActivitySubcomponent : AppComponent에 포함되는 서브 컴포넌트
@ActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {

    }

}
