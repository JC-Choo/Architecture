package kr.co.copy_ark_framework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class ArkBrFragment<VM : ViewModel, VDB : ViewDataBinding>(
    @LayoutRes protected val layoutRes: Int,
    protected val isAutoSubmit: Boolean = true
) : DaggerFragment(), CoroutineScope {

    protected lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = SupervisorJob()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        job.cancelChildren()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}