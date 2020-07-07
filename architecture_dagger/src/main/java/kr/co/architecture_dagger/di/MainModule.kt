package kr.co.architecture_dagger.di

import android.content.Context
import androidx.databinding.DataBindingUtil
import dagger.Module
import dagger.Provides
import kr.co.architecture_dagger.R
import kr.co.architecture_dagger.databinding.ActivityMainBinding
import kr.co.architecture_dagger.ui.MainActivity

@Module
class MainModule {
    @Provides
    @ActivityScope
    fun provideBinding(activity: MainActivity): ActivityMainBinding =
        DataBindingUtil.setContentView(activity, R.layout.activity_main)

    @Provides
    @ActivityContext
    fun provideContext(activity: MainActivity): Context =
        activity
}
