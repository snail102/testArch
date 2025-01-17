package com.example.testarchitecture.navigation.di

import android.util.Log
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [NavigationDependencies::class],
    modules = [NavigationModule::class]
)
@Singleton
interface NavigationComponent : NavigationApi {
    @Component.Factory
    interface Factory {
        fun create(dependencies: NavigationDependencies): NavigationComponent
    }

    companion object {
        fun initAndGet(dependencies: NavigationDependencies): NavigationComponent {
            Log.d("DI", "create NavigationComponent")
            return DaggerNavigationComponent.factory().create(dependencies)
        }
    }
}
