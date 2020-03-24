package com.example.codetask

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class InfoRepository {
    private val apiService = AppClientManager.client.create(ApiService::class.java)

    private fun loadInfo(keywords:String, page:Int, perPage :Int) =
        apiService.getPosts(keywords,page,perPage)



    fun searchInfoWithPagination(keywords:String,page:Int,perPage :Int): Single<GitItems> {
        return loadInfo(keywords, page,perPage)
    }

}