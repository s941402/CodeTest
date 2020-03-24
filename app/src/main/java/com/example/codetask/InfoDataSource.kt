package com.example.codetask

import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver

class InfoDataSource(
    private val repository: InfoRepository,
    private val query: String
) : PageKeyedDataSource<Int, GitUserInfoModel>() {

    private var retryQuery: (() -> Any)? = null //Keep the last query just in case it fails

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, GitUserInfoModel>
    ) {
        retryQuery = { loadInitial(params, callback) }
        executeQuery(1) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GitUserInfoModel>) {
        val page = params.key
        retryQuery = { loadAfter(params, callback) }
        executeQuery(page) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, GitUserInfoModel>
    ) {
        //Not implemented
    }

    private fun executeQuery(
        page: Int,
        callback: (MutableList<GitUserInfoModel>) -> Unit
    ) {
        repository.searchInfoWithPagination(query, page, 20)
            .map {
                it.items?.forEach { data -> data.viewType = (1..3).random() }
                it.items
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<MutableList<GitUserInfoModel>>() {
                override fun onSuccess(response: MutableList<GitUserInfoModel>) {
                    retryQuery = null
                    callback(response)
                }

                override fun onError(e: Throwable) {
                    // Error handle.
                    retryQuery = null
                }
            })

    }

    fun refresh() =
        this.invalidate()
}