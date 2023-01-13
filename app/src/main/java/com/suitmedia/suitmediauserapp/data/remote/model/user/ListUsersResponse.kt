package com.suitmedia.suitmediauserapp.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class ListUsersResponse(
    @SerializedName("data")
    val `data`: List<User>,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    @SerializedName("support")
    val support: Support? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null
)