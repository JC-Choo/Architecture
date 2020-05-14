//package dev.chu.architecture.kotlin.p87_sample
//
//import dagger.BindsInstance
//import dagger.Subcomponent
//import dev.chu.architecture.etc.ActivityScope
//
//@Subcomponent(modules = [SampleActivityModule::class])
//@ActivityScope
//interface SampleActivityComponent {
//
//    var sampleFragmentComponentFactory: SampleFragmentComponent.Factory
//
//    fun inject(activity: SampleActivity)
//
//    @Subcomponent.Factory
//    interface Factory {
//        fun create(module: SampleActivityModule, @BindsInstance activity: SampleActivity): SampleActivityComponent
//    }
//
//}
