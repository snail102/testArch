package com.example.testarchitecture

import android.app.Application
import com.example.testarchitecture.di.AppComponentHolder
import com.example.testarchitecture.di.InitDi

class App : Application() {
    private val appComponent by lazy {
        AppComponentHolder.getComponent()
    }

    override fun onCreate() {
        super.onCreate()
        InitDi.init()
        registerActivityLifecycleCallbacks(appComponent.activityLifecycleCallbacks)
    }
}
