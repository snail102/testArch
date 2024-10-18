package com.example.dicompose.binder

import androidx.lifecycle.LifecycleEventObserver
import com.example.di.BaseApi

interface BinderBaseApi {
    fun bind(entryId: String, api: BaseApi): LifecycleEventObserver
}
