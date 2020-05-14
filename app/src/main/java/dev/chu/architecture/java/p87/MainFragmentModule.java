package dev.chu.architecture.java.p87;

import java.util.Random;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dev.chu.architecture.etc.FragmentScope;

//@Module
//public class MainFragmentModule {
//
//    @Provides
//    @FragmentScope
//    public Integer provideInt() {
//        return new Random().nextInt();
//    }
//
//}

// 1. 보일러 플레이트 코드 제거

@Module
public class MainFragmentModule {

    @Named("fragment")
    @Provides
    @FragmentScope
    String provideString() {
        return "String from fragment";
    }

}