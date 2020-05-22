package dev.chu.myapplication.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geo(
    var lat: String,
    var lng: String
) : Parcelable