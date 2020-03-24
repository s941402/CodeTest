package com.example.codetask

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class InfoFactory(private var infoRepository: InfoRepository,private var query: String = "") : DataSource.Factory<Int, GitUserInfoModel>() {

    private val sourceLiveData= MutableLiveData<InfoDataSource>()

    override fun create(): DataSource<Int, GitUserInfoModel> {
        val source = InfoDataSource(infoRepository, query)
        this.sourceLiveData.postValue(source)
        return source
    }

    fun getSource() = sourceLiveData.value


    fun updateQuery(query: String) {
        this.query = query
        getSource()?.refresh()
    }
}