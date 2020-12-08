package dev.chu.myapplication.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(
    val postId: Long,
    val id: Long,
    var name: String,
    var email: String,
    var body: String
) : Parcelable