package com.example.dicompose.api

import android.app.Application
import com.example.di.BaseApi
import com.example.dicompose.binder.BinderBaseApi

interface InjectorComposeApi : BaseApi {
    val binderBaseApi: BinderBaseApi
    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
}
