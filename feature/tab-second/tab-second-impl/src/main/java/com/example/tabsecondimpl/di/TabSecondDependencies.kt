package com.example.tabsecondimpl.di

import com.example.di.BaseDependencies
import com.example.dicompose.binder.BinderBaseApi

interface TabSecondDependencies : BaseDependencies {
    val binderBaseApi: BinderBaseApi
}
