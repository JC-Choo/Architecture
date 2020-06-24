package kr.co.coroutine_retrofit_dagger.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dog (
    val breed: String?,
    val imageUrl: String?
): Parcelable