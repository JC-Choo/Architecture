package dev.chu.architecture.kotlin.p87

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dev.chu.architecture.App
import dev.chu.architecture.R
import javax.inject.Inject
import javax.inject.Named

//class MainActivity : AppCompatActivity() {
//
//    @Inject
//    lateinit var sharedPreferences: SharedPreferences
//
//    @Inject
//    lateinit var activityName: String
//
//    private lateinit var component: MainActivityComponent
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        component = (application as App).getAppComponent()
//            .mainActivityComponentFactory()
//            .create(MainActivityModule(), this).apply {
//                inject(this@MainActivity)
//            }
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_fl,
//                MainFragment()
//            )
//            .commit()
//
//        Log.d("MainActivity", activityName)
//    }
//
//    fun getComponent(): MainActivityComponent = component
//}

// 2. 보일러 플레이트 코드 제거

//class MainActivity : AppCompatActivity(), HasAndroidInjector {
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>

// 3. @ContributesAndroidInjector 애노테이션 활용
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    @Named("app")
    lateinit var appString: String

    @Inject
    @Named("activity")
    lateinit var activityString: String

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        Log.e("MainActivity", appString)
        Log.e("MainActivity", activityString)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fl,
                MainFragment()
            )
            .commit()
    }

//    override fun androidInjector(): AndroidInjector<Any> {
//        return androidInjector
//    }
}