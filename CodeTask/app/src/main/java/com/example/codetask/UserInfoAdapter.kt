package com.example.codetask

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserInfoAdapter(private val mContext: Context) :
    PagedListAdapter<GitUserInfoModel, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var resourceView = R.layout.adapter_single_item
        resourceView = when(viewType){
            2 -> R.layout.adapter_second_item
            3 -> R.layout.adapter_third_item
            else -> R.layout.adapter_single_item
        }
        val userInfoView = inflater.inflate(resourceView, parent, false)
        return UserInfoItemHolder(userInfoView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userInfoHolder = holder as UserInfoItemHolder
        configureQuestionnaireHolder(userInfoHolder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewType ?:0
    }

    private fun configureQuestionnaireHolder(userInfoItemHolder: UserInfoItemHolder, position: Int) {
        val userInfoModel = getItem(position)
        userInfoModel?.login?.let {
            userInfoItemHolder.tvSingleItemName.text = it
        }
        userInfoModel?.avatarUrl?.let {
            setImageView(mContext, it, userInfoItemHolder.ivSingleImage)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<GitUserInfoModel>() {
            override fun areItemsTheSame(oldItem: GitUserInfoModel, newItem: GitUserInfoModel): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: GitUserInfoModel, newItem: GitUserInfoModel): Boolean = oldItem == newItem
        }
    }
}