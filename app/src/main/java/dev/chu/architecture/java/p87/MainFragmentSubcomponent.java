package dev.chu.architecture.java.p87;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dev.chu.architecture.etc.FragmentScope;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentSubcomponent extends AndroidInjector<MainFragment> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainFragment> {

    }

}
