package kr.co.architecture_dagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * 애플리케이션 스코프로 싱글톤으로 관리
 * - [creators] : ViewModel class 를 키로 갖는 멀티 바인딩 Map
 * - [creator] : ViewModel 클래스를 키로 하며, ViewModel 객체를 생성하는 Provider 를 가져온다.
 * - [modelClass.isAssignableFrom(key)] : 해당 파라미터에 대해 값이 있는지 여부
 * - [creator.get() as T]] : Dagger의 Provider로 부터 ViewModel 객체 생성 및 반환
 */

@Singleton
class AppViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if(creator == null) {
            for ((key, value) in creators) {
                if(modelClass.isAssignableFrom(key)) {
                    creator = value
                }
            }
        }

        if(creator == null)
            error("Unknown model class $modelClass")

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw e
        }
    }
}