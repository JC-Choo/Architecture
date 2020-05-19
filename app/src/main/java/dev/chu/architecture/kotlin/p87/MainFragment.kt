package dev.chu.architecture.kotlin.p87

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dev.chu.architecture.R
import dev.chu.architecture.kotlin.p87.MainFragmentModule
import javax.inject.Inject
import javax.inject.Named

//class MainFragment : Fragment() {
//
//    @Inject
//    lateinit var sharedPreferences: SharedPreferences
//
//    @Inject
//    lateinit var activityName: String
//
//    @Inject
//    @JvmField
//    var randomNumber: Int = 0
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (activity is MainActivity) {
//            (activity as MainActivity).getComponent()
//                .mainFragmentFactory()
//                .create(MainFragmentModule(), this)
//                .inject(this)
//        }
//
//        Log.d("MainFragment", activityName)
//        Log.d("MainFragment", "randomNumber = $randomNumber")
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
//    }
//}

// 보일러 플레이트 코드 제거

class MainFragment : Fragment() {

    @Inject
    @Named("app")
    lateinit var appString: String

    @Inject
    @Named("activity")
    lateinit var activityString: String

    @Inject
    @Named("fragment")
    lateinit var fragmentString: String

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        Log.e("MainFragment", appString)
        Log.e("MainFragment", activityString)
        Log.e("MainFragment", fragmentString)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}