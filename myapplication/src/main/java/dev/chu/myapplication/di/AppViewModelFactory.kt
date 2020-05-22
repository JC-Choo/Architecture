package dev.chu.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AppViewModelFactory @Inject constructor(
    // ViewModel 클래스를 키로 갖는 멀티 바인딩 Map
    private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // ViewModel 클래스를 키로 하며, ViewModel 객체를 생성하는 Provider 를 가져온다.
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if(creator == null) {
            // 클래스 키로 못 찾았다면, 적당한 Provider가 있는지 다시 Map에서 찾는다.
            for(entry in creators.entries) {
                if(modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                }
            }
        }

        if(creator == null)
            throw IllegalArgumentException("Unknown model class $modelClass")

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}