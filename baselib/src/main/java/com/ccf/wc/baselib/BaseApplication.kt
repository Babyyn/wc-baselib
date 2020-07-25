package com.ccf.wc.baselib

import android.app.Application
import android.content.res.Configuration
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseApplication : Application() {

    private val appModuleClassList: MutableList<Class<out BaseAppModule>> = mutableListOf()

    private val appModuleClass: MutableList<BaseAppModule> = mutableListOf()

    private var lazyInited = false

    override fun onCreate() {
        super.onCreate()

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)

        initBaseAppModules()
        appModuleOnCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
        for (appModule in appModuleClass) {
            appModule.onTerminate()
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        for (appModule in appModuleClass) {
            appModule.onLowMemory()
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        for (appModule in appModuleClass) {
            appModule.onTrimMemory(level)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        for (appModule in appModuleClass) {
            appModule.onConfigurationChanged(newConfig)
        }
    }

    abstract fun initBaseAppModules()

    fun lazyInitAfterLaunched() {
        if (lazyInited) {
            return
        }
        for (module in appModuleClass) {
            if (module.doNotIncludeWhenLaunch()) {
                module.onCreate()
            }
            module.lazyInitAfterLaunched()
        }
        lazyInited = true
    }

    protected fun registerBaseAppModule(clazz: Class<out BaseAppModule>) {
        appModuleClassList.add(clazz)
    }

    private fun appModuleOnCreate() {
        for (clazz in appModuleClassList) {
            val appModule: BaseAppModule = clazz.newInstance()
            appModuleClass.add(appModule)
            appModule.application = this
            if (appModule.doNotIncludeWhenLaunch()) {
                // skip
            } else {
                appModule.onCreate()
            }
        }
    }

}