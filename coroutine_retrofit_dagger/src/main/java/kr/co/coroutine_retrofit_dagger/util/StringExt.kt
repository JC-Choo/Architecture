package kr.co.coroutine_retrofit_dagger.util

import android.util.Log

fun String.logCoroutineThreadNameOnly() {
    Log.e("TestCoroutine", "Thread for $this is: ${Thread.currentThread().name}")
}