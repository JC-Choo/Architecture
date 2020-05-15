package dev.chu.architecture.kotlin.p50

import dagger.Module
import dagger.Provides

@Module
class FamilyModule {

    @Provides
    fun provideParent(): Parent {
        return Parent()
    }

    @Provides
    fun provideSelf(): Self {
        return Self()
    }

    @Provides
    fun provideChild(): Child {
        return Child()
    }

}
