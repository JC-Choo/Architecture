package dev.chu.myapplication.ui

import android.content.Context
import androidx.databinding.DataBindingUtil
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dev.chu.myapplication.R
import dev.chu.myapplication.databinding.ActivityMainBinding
import dev.chu.myapplication.di.ActivityContext
import dev.chu.myapplication.di.ActivityScope
import dev.chu.myapplication.di.FragmentScope
import dev.chu.myapplication.ui.detail.PostDetailFragment
import dev.chu.myapplication.ui.post.PostFragment
import dev.chu.myapplication.ui.post.PostModule

@Module
abstract class MainModule {
    companion object {
        @Provides
        @ActivityScope
        fun provideBinding(activity: MainActivity) : ActivityMainBinding {
            return DataBindingUtil.setContentView(activity, R.layout.activity_main)
        }

        @Provides
        @ActivityContext
        fun provideContext(activity: MainActivity) : Context {
            return activity
        }
    }

    // 서브 컴포넌트 정의
    @FragmentScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun getPostFragment(): PostFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostDetailFragment::class])
    abstract fun getPostDetailFragment(): PostDetailFragment
}
