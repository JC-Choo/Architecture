//package dev.chu.architecture.kotlin.p87_sample
//
//import dagger.BindsInstance
//import dagger.Subcomponent
//import dev.chu.architecture.etc.FragmentScope
//
//@FragmentScope
//@Subcomponent(modules = [SampleFragmentModule::class])
//interface SampleFragmentComponent {
//
//    fun inject(fragment: SampleFragment)
//
//    @Subcomponent.Factory
//    interface Factory {
//        fun create(
//            module: SampleFragmentModule,
//            @BindsInstance fragment: SampleFragment
//        ): SampleFragmentComponent
//    }
//
//}
