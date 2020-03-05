package com.ccf.wc.baselib

import android.content.res.Configuration

abstract class BaseAppModule {

    lateinit var application: BaseApplication

    abstract fun onCreate()

    fun onTerminate() {
    }

    fun onLowMemory() {
    }

    fun onTrimMemory(level: Int) {
    }

    fun onConfigurationChanged(newConfig: Configuration) {
    }
}