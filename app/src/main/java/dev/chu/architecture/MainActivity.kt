package dev.chu.architecture

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.chu.architecture.java.p87.MainActivityComponent
import dev.chu.architecture.java.p87.MainActivityModule
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
            .mainActivityComponentBuilder()
            .setModule(MainActivityModule())
            .setActivity(this)
            .build()
        component.inject(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

    fun getComponent(): MainActivityComponent = component
}