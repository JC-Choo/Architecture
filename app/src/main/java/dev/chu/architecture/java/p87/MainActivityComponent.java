package dev.chu.architecture.java.p87;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dev.chu.architecture.etc.ActivityScope;

@Subcomponent(modules = MainActivityModule.class)
@ActivityScope
public interface MainActivityComponent {

    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainActivityModule module);
        @BindsInstance
        Builder setActivity(MainActivity activity);
        MainActivityComponent build();
    }

}
