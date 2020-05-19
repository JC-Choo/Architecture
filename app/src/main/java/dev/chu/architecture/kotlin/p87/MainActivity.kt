package dev.chu.architecture.kotlin.p87

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dev.chu.architecture.App
import dev.chu.architecture.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var activityName: String

    private lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = (application as App).appComponent
            .mainActivityComponentFactory()
            .create(MainActivityModule(), this).apply {
                inject(this@MainActivity)
            }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fl,
                MainFragment()
            )
            .commit()

        Log.d("MainActivity", activityName)
    }

    fun getComponent(): MainActivityComponent = component
}