package dev.chu.architecture.kotlin.p87

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.chu.architecture.R
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var activityName: String

    @Inject
    @JvmField
    var randomNumber: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is MainActivity) {
            (activity as MainActivity).getComponent()
                .mainFragmentFactory()
                .create(MainFragmentModule(), this)
                .inject(this)
        }

        Log.d("MainFragment", activityName)
        Log.d("MainFragment", "randomNumber = $randomNumber")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}