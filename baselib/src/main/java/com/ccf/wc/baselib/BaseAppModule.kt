package com.ccf.wc.baselib

import android.content.res.Configuration
import android.util.Log

abstract class BaseAppModule {

    lateinit var application: BaseApplication

    open fun onCreate() {
        Log.d(this.javaClass.name, "onCreate")
    }

    open fun lazyInitAfterLaunched() {
        Log.d(this.javaClass.name, "lazyInitAfterLaunched")
    }

    open fun doNotIncludeWhenLaunch(): Boolean = false

    fun onTerminate() {
    }

    fun onLowMemory() {
    }

    fun onTrimMemory(level: Int) {
    }

    fun onConfigurationChanged(newConfig: Configuration) {
    }
}