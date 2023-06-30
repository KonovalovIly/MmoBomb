package com.example.mmobomb.presentation

import android.app.Application
import com.example.mmobomb.di.appModule
import com.example.mmobomb.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, appModule))
        }
    }
}