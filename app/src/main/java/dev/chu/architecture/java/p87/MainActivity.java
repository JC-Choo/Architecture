package dev.chu.architecture.java.p87;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dev.chu.architecture.R;

// 1. 보일러 플레이트 코드 제거

public class MainActivity extends AppCompatActivity implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        Log.e("MainActivity", appString);
        Log.e("MainActivity", activityString);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MainActivity");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fl, new MainFragment())
                .commit();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}

// 2. ContributesAndroidInjector 사용

//public class MainActivity extends DaggerAppCompatActivity {
//
//    @Inject
//    @Named("app")
//    String appString;
//
//    @Inject
//    @Named("activity")
//    String activityString;
//
//    private MainActivityComponent component;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
//        Log.e("MainActivity", appString);
//        Log.e("MainActivity", activityString);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        setTitle("MainActivity");
////        setTitle("MainActivity_1. 보일러 플레이트 코드 제거");
//        setTitle("MainActivity_2. ContributesAndroidInjector 사용");
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_fl, new MainFragment())
//                .commit();
//    }
//
//}
