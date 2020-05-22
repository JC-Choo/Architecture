package dev.chu.myapplication.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long,
    var name: String,
    var username: String,
    var email: String,
    var address: dev.chu.myapplication.data.entity.Address,
    var phone: String,
    var website: String,
    var company: dev.chu.myapplication.data.entity.Company
) : Parcelable