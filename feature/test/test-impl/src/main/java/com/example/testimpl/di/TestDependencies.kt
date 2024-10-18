package com.example.testimpl.di

import com.example.di.BaseDependencies
import com.example.dicompose.binder.BinderBaseApi

interface TestDependencies : BaseDependencies {
    val binderBaseApi: BinderBaseApi
}
