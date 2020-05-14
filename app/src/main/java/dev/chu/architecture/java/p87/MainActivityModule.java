package dev.chu.architecture.java.p87;

import dagger.Module;
import dagger.Provides;
import dev.chu.architecture.MainActivity;
import dev.chu.architecture.etc.ActivityScope;

@Module(subcomponents = MainFragmentComponent.class)
public class MainActivityModule {

    @Provides
    @ActivityScope
    public String provideActivityName() {
        return MainActivity.class.getSimpleName();
    }

}
