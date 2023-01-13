package com.suitmedia.suitmediauserapp.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("last_name")
    val lastName: String? = null
)