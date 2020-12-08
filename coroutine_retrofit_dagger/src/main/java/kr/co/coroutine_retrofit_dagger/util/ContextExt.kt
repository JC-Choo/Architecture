package kr.co.coroutine_retrofit_dagger.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(message: String, duration: Int = 0) =
    Toast.makeText(this, message, duration).show()

fun Context.showToast(@StringRes res: Int, duration: Int = 0) =
    Toast.makeText(this, res, duration).show()