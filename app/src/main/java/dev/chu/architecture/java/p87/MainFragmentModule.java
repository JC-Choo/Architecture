package dev.chu.architecture.java.p87;

import java.util.Random;

import dagger.Module;
import dagger.Provides;
import dev.chu.architecture.etc.FragmentScope;

@Module
public class MainFragmentModule {

    @Provides
    @FragmentScope
    public Integer provideInt() {
        return new Random().nextInt();
    }

}
