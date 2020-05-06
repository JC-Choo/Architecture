package dev.chu.architecture.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GithubRepos(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("owner")
    var owner: Owner,
    @SerializedName("updated_at")
    var updatedAt: Date
) : Parcelable