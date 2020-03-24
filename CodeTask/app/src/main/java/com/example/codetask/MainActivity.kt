package com.example.codetask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val infoViewModel: InfoViewModel by viewModel()
    private val userInfoAdapter = UserInfoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setOnClickListener()
        observeViewModelData()
    }

    private fun initView() {
        rvMainList.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(this)
        rvMainList.layoutManager = mLayoutManager
        rvMainList.adapter = userInfoAdapter
    }

    private fun setOnClickListener() {
        ivMainSearch.setOnClickListener {
            val keyword = etMainSearchText.text.toString().trim()
            if (keyword.isNotEmpty()) {
                infoViewModel.fetchUserInfoByKeyword(keyword)
            }
        }

        ivMainClose.setOnClickListener {
            etMainSearchText.text?.clear()
        }
    }

    private fun observeViewModelData() {
        infoViewModel.userInfoLiveData.observe(this, Observer {
            userInfoAdapter.submitList(it)
        })
    }
}

