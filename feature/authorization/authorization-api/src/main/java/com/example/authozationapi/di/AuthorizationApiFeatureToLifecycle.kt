package com.example.authozationapi.di

import com.example.di.BaseApi
import com.example.dicompose.binder.BinderBaseApiToLifecycle

interface AuthorizationApiFeatureToLifecycle :
    BaseApi,
    BinderBaseApiToLifecycle {
    val authorizationFeatureStarter: AuthorizationFeatureStarter
}
