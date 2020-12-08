package dev.chu.architecture.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String,
    var age: Int? = null
) : Parcelable