package com.ccf.wc.baselib

import android.app.Application
import android.content.res.Configuration
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseApplication : Application() {

    private val appModuleClassList: MutableList<Class<out BaseAppModule>> = mutableListOf()

    private val appModuleClass: MutableList<BaseAppModule> = mutableListOf()

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

    protected fun registerBaseAppModule(clazz: Class<out BaseAppModule>) {
        appModuleClassList.add(clazz)
    }

    private fun appModuleOnCreate() {
        for (clazz in appModuleClassList) {
            var baseAppModule: BaseAppModule = clazz.newInstance()
            appModuleClass.add(baseAppModule)
            baseAppModule.application = this
            baseAppModule.onCreate()
        }
    }

}