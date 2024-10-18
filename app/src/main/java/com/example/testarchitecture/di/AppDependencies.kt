package com.example.testarchitecture.di

import android.app.Application
import com.example.di.BaseDependencies
import com.example.domain.UserRepository
import com.example.testarchitecture.navigation.di.NavigationApi

interface AppDependencies : BaseDependencies {
    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
    val navigationApi: NavigationApi
    val userRepository: UserRepository
}
