package dev.chu.myapplication.ui.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Module
import dagger.Provides
import dev.chu.myapplication.databinding.FragmentPostBinding
import dev.chu.myapplication.di.ApplicationContext
import dev.chu.myapplication.di.FragmentScope

@Module
class PostModule {
    // 데이터 바인딩 클래스 제공
    @Provides
    @FragmentScope
    fun provideBinding(@ApplicationContext context: Context): FragmentPostBinding {
        return FragmentPostBinding.inflate(LayoutInflater.from(context), null, false)
    }

    // RecyclerView 용 레이아웃 매니져
    @Provides
    @FragmentScope
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return object : LinearLayoutManager(context) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
    }

    // Navigation 컴포넌트에서 목적지 간 이동을 담당하는 NavController
    @Provides
    @FragmentScope
    fun provideNavController(fragment: PostFragment): NavController {
        return NavHostFragment.findNavController(fragment)
    }
}