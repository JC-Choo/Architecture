package dev.chu.myapplication.ui.user

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import dev.chu.myapplication.databinding.FragmentUserBinding
import dev.chu.myapplication.di.ActivityContext
import dev.chu.myapplication.di.FragmentScope

@Module
class UserModule {
    @Provides
    @FragmentScope
    fun provideBinding(@ActivityContext context: Context): FragmentUserBinding {
        return FragmentUserBinding.inflate(LayoutInflater.from(context))
    }
}