package dev.chu.architecture.kotlin

import dagger.Module
import dagger.Provides

@Module
class MyModule {

    @Provides
    fun provideHelloWorld(): String {
        return "Hello World"
    }

//    @Provides
//    fun provideChu(): String {
//        return "Chu"
//    }
    // 같은 컴포넌트 내 같은 타입 -> 에러 발생
    // error: [Dagger/DuplicateBindings] java.lang.String is bound multiple times:
}