//package dev.chu.architecture.kotlin.p87_sample
//
//import android.app.Activity
//import android.content.Context
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import dev.chu.architecture.R
//import dev.chu.architecture.di.FragmentModule
//import dev.chu.architecture.java.p87.MainFragment
//import javax.inject.Inject
//
//class SampleFragment : Fragment() {
//    private val TAG = SampleFragment::class.java.simpleName
//
//    @Inject
//    lateinit var preference: SharedPreferences
//
////    @Inject
////    lateinit var sampleActivityName: String
//
//    @Inject
//    @JvmField
//    var randomNumber: Int = 0
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//        if(activity is SampleActivity) {
//            (activity as SampleActivity).getComponent()
//                .fragmentComponentBuilder
//                .setModule(FragmentModule())
//                .setFragment(this)
//                .build()
//                .inject(this)
//        }
//
//        Log.i(TAG, "onAttach")
////        Log.i(TAG, "activityName = $sampleActivityName")
//        Log.i(TAG, "randomNumber = $randomNumber")
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Log.i(TAG, "onCreateView")
//
//        return inflater.inflate(R.layout.fragment_sample, container, false)
//    }
//}
