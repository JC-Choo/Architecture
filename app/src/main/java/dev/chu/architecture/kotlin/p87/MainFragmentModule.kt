package dev.chu.architecture.kotlin.p87

import dagger.Module
import dagger.Provides
import dev.chu.architecture.etc.FragmentScope
import java.util.*

@Module
class MainFragmentModule {
    @Provides
    @FragmentScope
    fun provideInteger() = Random().nextInt()

}
