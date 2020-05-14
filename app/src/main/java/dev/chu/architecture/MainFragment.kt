//package dev.chu.architecture
//
//import android.content.Context
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import dev.chu.architecture.java.p87.MainFragmentModule
//import javax.inject.Inject
//
//class MainFragment : Fragment() {
//
//    private val TAG = MainFragment::class.java.simpleName
//
//    @Inject
//    lateinit var sharedPreferences: SharedPreferences
//
//    @Inject
//    lateinit var activityName: String
//
//    @Inject
//    var randomNumber: Int? = null
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if(activity is MainActivity) {
//            (activity as MainActivity).getComponent()
//                .mainFragmentComponentBuilder()
//                .setModule(MainFragmentModule())
//                .setFragment(this)
//                .build()
//                .inject(this)
//        }
//
//        Log.i(TAG, "onAttach")
//        Log.i(TAG, "activityName = $activityName")
//        Log.i(TAG, "randomNumber = $randomNumber")
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        Log.i(TAG, "onCreateView")
//        return inflater.inflate(R.layout.fragment_main, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        Log.i(TAG, "onViewCreated")
//    }
//
//}
