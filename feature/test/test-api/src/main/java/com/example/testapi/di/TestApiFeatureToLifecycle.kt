package com.example.testapi.di

import com.example.di.BaseApi
import com.example.dicompose.binder.BinderBaseApiToLifecycle
import com.example.testapi.domain.ExternalRepository

interface TestApiFeatureToLifecycle :
    BaseApi,
    BinderBaseApiToLifecycle {
    val testFeatureStarter: TestFeatureStarter

    val externalRepository: ExternalRepository
}
