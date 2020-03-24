package com.example.codetask

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/search/users")
    fun getPosts(@Query("q") keyword: String,@Query("page") page: Int,@Query("per_page") perPage: Int): Single<GitItems>

}
