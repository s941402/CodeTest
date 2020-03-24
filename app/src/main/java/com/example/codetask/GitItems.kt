package com.example.codetask

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitItems {
    @SerializedName("total_count")
    @Expose
    var totalCount: Int? = null
    @SerializedName("items")
    var items: MutableList<GitUserInfoModel>? = null
}