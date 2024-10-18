package com.example.dicompose.di

import android.app.Application
import com.example.dicompose.binder.BinderBaseApi
import com.example.dicompose.binder.BinderBaseApiImpl
import dagger.Binds
import dagger.Module

@Module
interface InjectorComposeModule {
    @Binds
    fun bindBinderApiToEntryLifecycleImplBinderApiToEntryLifecycle(binderApiToEntryLifecycleImpl: BinderBaseApiImpl): BinderBaseApi

    @Binds
    fun bindBinderApiToEntryLifecycleImplActivityLifecycleCallbacks(
        binderApiToEntryLifecycleImpl: BinderBaseApiImpl,
    ): Application.ActivityLifecycleCallbacks
}
