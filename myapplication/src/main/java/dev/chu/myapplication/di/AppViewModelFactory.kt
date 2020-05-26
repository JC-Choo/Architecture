package dev.chu.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

// 애플리케이션 스코프로 싱글톤으로 관리한다.
@Singleton
class AppViewModelFactory @Inject constructor(
    // ViewModel 클래스를 키로 갖는 멀티 바인딩 Map
    private val creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // ViewModel 클래스를 키로 하며, ViewModel 객체를 생성하는 Provider 를 가져온다.
        var creator: Provider<out ViewModel>? = creators[modelClass]
//        var creator = creators[modelClass]
        if(creator == null) {
            // 클래스 키로 못 찾았다면, 적당한 Provider가 있는지 다시 Map에서 찾는다.
//            creators.entries.map { entry ->
//                if(modelClass.isAssignableFrom(entry.key)) {        // isAssignableFrom : 해당 파라미터에 대해 값이 있는지 여부
//                    creator = entry.value
//                }
//            }

//            for ((key, value) in creators) {
//                if (modelClass.isAssignableFrom(key)) {
//                    creator = value
//                }
//            }

            for(entry in creators.entries) {
                if(modelClass.isAssignableFrom(entry.key)) {        // isAssignableFrom : 해당 파라미터에 대해 값이 있는지 여부
                    creator = entry.value
                }
            }
        }

        if(creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }

        try {
            // Dagger의 Provider로 부터 ViewModel 객체 생성 및 반환
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}