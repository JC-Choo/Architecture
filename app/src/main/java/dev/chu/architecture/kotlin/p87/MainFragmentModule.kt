package dev.chu.architecture.kotlin.p87

import dagger.Module
import dagger.Provides
import dev.chu.architecture.etc.FragmentScope
import java.util.*
import javax.inject.Named

//@Module
//class MainFragmentModule {
//    @Provides
//    @FragmentScope
//    fun provideInteger() = Random().nextInt()
//
//}

// 보일러 플레이트 코드 제거

@Module
class MainFragmentModule {
    @Named("fragment")
    @Provides
    @FragmentScope
    fun provideString() = "String from fragment"
}
