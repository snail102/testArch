package com.example.tabfirstimpl.di

import com.example.di.BaseDependencies
import com.example.dicompose.binder.BinderBaseApi

interface TabFirstDependencies : BaseDependencies {
    val binderBaseApi: BinderBaseApi
}
