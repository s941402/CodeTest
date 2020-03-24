package com.example.codetask

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GitUserInfoModel(
    @SerializedName("login")
    @Expose
    var login: String? = null,
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null,

    var viewType: Int = 1
)
