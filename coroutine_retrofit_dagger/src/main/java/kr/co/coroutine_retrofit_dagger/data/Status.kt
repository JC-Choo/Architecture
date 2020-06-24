package kr.co.coroutine_retrofit_dagger.data

sealed class Status {
    data class Success<T>(val data: T) : Status()
    data class Error(val error: String): Status()
    data class Loading(val loading: Boolean = true): Status()
}