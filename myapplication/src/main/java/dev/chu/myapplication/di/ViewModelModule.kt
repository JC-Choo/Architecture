package dev.chu.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.chu.myapplication.ui.detail.PostDetailViewModel
import dev.chu.myapplication.ui.post.PostViewModel
import dev.chu.myapplication.ui.user.UserViewModel

// ViewModel 과 관련된 내용을 오브젝트 그래프로 관리
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindsPostViewModel(viewModel: PostViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel::class)
    abstract fun bindsPostDetailViewModel(viewModel: PostDetailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindsUserViewModel(viewModel: UserViewModel) : ViewModel
}