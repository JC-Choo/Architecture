package dev.chu.architecture;

import android.app.Application;

import dev.chu.architecture.java.p87.AppComponent;
import dev.chu.architecture.java.p87.AppModule;
import dev.chu.architecture.java.p87.DaggerAppComponent;

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
