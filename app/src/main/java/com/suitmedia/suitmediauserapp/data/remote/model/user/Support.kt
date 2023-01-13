package com.suitmedia.suitmediauserapp.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("url")
    val url: String? = null
)