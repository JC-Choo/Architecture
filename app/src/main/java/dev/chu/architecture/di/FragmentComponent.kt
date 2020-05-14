//package dev.chu.architecture.di
//
//import dagger.BindsInstance
//import dagger.Subcomponent
//import dev.chu.architecture.etc.FragmentScope
//import dev.chu.architecture.java.p87.MainFragment
//import dev.chu.architecture.kotlin.p87_sample.SampleFragment
//
//@FragmentScope
//@Subcomponent(modules = [FragmentModule::class])
//interface FragmentComponent {
//
//    fun inject(fragment: SampleFragment)
//    fun inject(fragment: MainFragment)
//
//    @Subcomponent.Builder
//    interface Builder {
//        fun setModule(module: FragmentModule): Builder
//
//        @BindsInstance
//        fun setFragment(fragment: SampleFragment): Builder
//
//        @BindsInstance
//        fun setFragment(fragment: MainFragment): Builder
//
//        fun build(): FragmentComponent
//    }
//
//}