package com.example.codetask

import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_single_item.view.*

class UserInfoItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val llItem: LinearLayout = itemView.llItem
    val ivSingleImage: AppCompatImageView = itemView.ivSingleImage
    val tvSingleItemName: AppCompatTextView = itemView.tvSingleItemName
}