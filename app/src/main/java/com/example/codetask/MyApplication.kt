package com.example.codetask

import android.app.Application
import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            val list = listOf(myModule, repoModule)
            modules(list)
        }
    }
}