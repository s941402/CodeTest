package com.example.codetask

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView

fun setImageView(mContext: Context, url: String, imageView: AppCompatImageView) {
    GlideApp.with(mContext)
        .load(url)
        .skipMemoryCache(true)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView)
}
