package com.example.tabfirstapi.di

import com.example.di.BaseApi
import com.example.dicompose.binder.BinderBaseApiToLifecycle

interface TabFirstApiFeatureToLifecycle :
    BaseApi,
    BinderBaseApiToLifecycle {
    val tabFirstFeatureStarter: TabFirstFeatureStarter
}
