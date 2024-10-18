package com.example.tabsecondapi.di

import com.example.di.BaseApi
import com.example.dicompose.binder.BinderBaseApiToLifecycle

interface TabSecondApiFeatureToLifecycle :
    BaseApi,
    BinderBaseApiToLifecycle {
    val tabSecondFeatureStarter: TabSecondFeatureStarter
}
