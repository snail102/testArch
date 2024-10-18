package com.example.testarchitecture.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.testarchitecture.navigation.di.NavigationApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [MainViewModelModule::class],
    dependencies = [AppDependencies::class]
)
@Singleton
internal interface AppComponent : AppApi {
    val viewModelFactory: ViewModelProvider.Factory
    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
    val navigationApi: NavigationApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: AppDependencies): AppComponent
    }

    companion object {
        fun initAndGet(dependencies: AppDependencies): AppComponent {
            Log.d("DI", "create AppComponent")
            return DaggerAppComponent.factory().create(dependencies)
        }
    }
}
