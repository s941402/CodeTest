package com.example.codetask

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoViewModel(infoRepository: InfoRepository) : ViewModel() {
    private val infoDataSource = InfoFactory(infoRepository = infoRepository)
    val userInfoLiveData = LivePagedListBuilder(infoDataSource, pagedListConfig()).build()

    fun fetchUserInfoByKeyword(query: String) {
        val search = query.trim()
        infoDataSource.updateQuery(search)
    }
}