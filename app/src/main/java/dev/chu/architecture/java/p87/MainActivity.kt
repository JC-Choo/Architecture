//package dev.chu.architecture.java.p87
//
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import dev.chu.architecture.App
//import dev.chu.architecture.java.p87.MainFragment
//import dev.chu.architecture.R
//import javax.inject.Inject
//
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
//        title = "MainActivity"
//
//        component = (application as App).appComponent
//            .mainActivityComponentBuilder()
//            .setModule(MainActivityModule())
//            .setActivity(this)
//            .build()
//        component.inject(this)
//
//        Log.i(activityName, "onCreate")
//
//        supportFragmentManager.beginTransaction()
//            .replace(
//                R.id.main_fl,
//                MainFragment()
//            )
//            .commit()
//    }
//
//    fun getComponent(): MainActivityComponent = component
//}