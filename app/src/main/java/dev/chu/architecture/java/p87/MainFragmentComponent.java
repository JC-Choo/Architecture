package dev.chu.architecture.java.p87;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dev.chu.architecture.etc.FragmentScope;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface Builder {
        MainFragmentComponent.Builder setModule(MainFragmentModule module);
        @BindsInstance
        MainFragmentComponent.Builder setFragment(MainFragment fragment);
        MainFragmentComponent build();
    }

}
