package dev.chu.architecture.kotlin

import androidx.annotation.Nullable
import dagger.Module
import dagger.Provides
import dev.chu.architecture.entity.Person

@Module
class MyModule {

//    @Provides
//    fun provideHelloWorld(): String {
//        return "Hello World"
//    }

    @Provides
    fun provideName(): String {
        return "Chu"
    }

    @Provides
    @Nullable
    fun provideAge(): Int? {
        return null
    }

    @Provides
    fun providePerson(name: String, @Nullable age: Int?): Person {
        return Person(name, age)
    }

    // 같은 컴포넌트 내 같은 타입 -> 에러 발생
    // error: [Dagger/DuplicateBindings] java.lang.String is bound multiple times:
}