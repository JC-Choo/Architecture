//package dev.chu.architecture.kotlin.p87_sample
//
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import dev.chu.architecture.App
//import dev.chu.architecture.R
//import dev.chu.architecture.di.ActivityComponent
//import dev.chu.architecture.di.ActivityModule
//import dev.chu.architecture.entity.Sample
//import kotlinx.android.synthetic.main.activity_sample.*
//import javax.inject.Inject
//
//class SampleActivity : AppCompatActivity() {
//
//    @Inject
//    lateinit var sharedPreferences: SharedPreferences
//
////    @Inject
////    lateinit var sampleActivityName: String
//
//    private lateinit var component: ActivityComponent
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sample)
//
//        title = "SampleActivity"
//
//        component = (application as App).getAppComponent()
//            .activityComponentBuilder
//            .setModule(ActivityModule())
//            .setActivity(sampleActivity = this)
//            .build()
//        component.inject(this)
//
////        Log.i(sampleActivityName, "onCreate")
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.sample_fl, SampleFragment())
//            .commit()
//
//        setRecyclerView()
//    }
//
//    private fun setRecyclerView() {
//        val list : MutableList<Sample> = mutableListOf()
//
//        for(i in 0 until 20) {
//            list.add(Sample("$i 번째"))
//        }
//
//        val adapter = SampleAdapter(list)
//        sample_rv.adapter = adapter
//    }
//
//    fun getComponent(): ActivityComponent = component
//
//}