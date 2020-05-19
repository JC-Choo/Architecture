package dev.chu.architecture;

import android.app.Application;

import dev.chu.architecture.kotlin.p87.AppComponent;
import dev.chu.architecture.kotlin.p87.AppModule;
import dev.chu.architecture.kotlin.p87_sample.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(this, new AppModule());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

// 1. 보일러 플레이트 코드 제거

//public class App extends Application implements HasAndroidInjector {
//
//    @Inject
//    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        DaggerAppComponent.factory()
//                .create(this)
//                .inject(this);
//    }
//
//    @Override
//    public AndroidInjector<Object> androidInjector() {
//        return dispatchingAndroidInjector;
//    }
//
//}

// 2. ContributesAndroidInjector 사용

//public class App extends DaggerApplication {
//
//    @Override
//    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        return DaggerAppComponent.factory().create(this);
//    }
//
//}
