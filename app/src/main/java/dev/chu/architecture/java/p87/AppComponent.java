package dev.chu.architecture.java.p87;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dev.chu.architecture.App;


//@Component(modules = AppModule.class)
//@Singleton
//public interface AppComponent {
//
//    MainActivityComponent.Builder mainActivityComponentBuilder();
//
//    void inject(App app);
//
//    @Component.Factory
//    interface Factory {
//        AppComponent create(@BindsInstance App app, AppModule appModule);
//    }
//
//}

// 1. 보일러 플레이트 코드 제거

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    interface Factory extends AndroidInjector.Factory<App> {

    }

}