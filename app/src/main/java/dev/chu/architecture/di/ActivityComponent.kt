//package dev.chu.architecture.di
//
//import dagger.BindsInstance
//import dagger.Subcomponent
//import dev.chu.architecture.di.ActivityScope
//import dev.chu.architecture.java.p87.MainActivity
//import dev.chu.architecture.kotlin.p87_sample.SampleActivity
//
//@Subcomponent(modules = [ActivityModule::class])
//@ActivityScope
//interface ActivityComponent {
//
//    var fragmentComponentBuilder: FragmentComponent.Builder
//
//    fun inject(activity: SampleActivity)
//    fun inject(activity: MainActivity)
//
//    @Subcomponent.Builder
//    interface Builder {
//
//        fun setModule(module: ActivityModule): Builder
//
//        @BindsInstance
//        fun setActivity(sampleActivity: SampleActivity): Builder
//
//        @BindsInstance
//        fun setActivity(mainActivity: MainActivity): Builder
//
//        fun build(): ActivityComponent
//    }
//
//}