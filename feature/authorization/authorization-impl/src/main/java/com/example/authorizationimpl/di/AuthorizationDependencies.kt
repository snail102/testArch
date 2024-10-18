package com.example.authorizationimpl.di

import com.example.di.BaseDependencies
import com.example.dicompose.binder.BinderBaseApi

interface AuthorizationDependencies : BaseDependencies {
    val binderBaseApi: BinderBaseApi
}
