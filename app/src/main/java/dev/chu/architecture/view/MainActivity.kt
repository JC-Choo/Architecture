package dev.chu.architecture.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dev.chu.architecture.R
import dev.chu.architecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }
    }
}