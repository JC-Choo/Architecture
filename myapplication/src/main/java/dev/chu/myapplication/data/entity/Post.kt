package dev.chu.myapplication.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    var userId: Long,
    var id: Long,
    var title: String,
    var body: String
) : Parcelable