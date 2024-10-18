package com.example.authorizationimpl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.authozationapi.di.AuthorizationApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AuthorizationModule::class, AuthorizationViewModelModule::class],
    dependencies = [AuthorizationDependencies::class]
)
@Singleton
internal interface AuthorizationComponent : AuthorizationApiFeatureToLifecycle {
    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: AuthorizationDependencies): AuthorizationComponent
    }

    companion object {
        fun initAndGet(dependencies: AuthorizationDependencies): AuthorizationComponent {
            Log.d("DI", "create AuthorizationComponent")
            return DaggerAuthorizationComponent.factory().create(dependencies)
        }
    }
}
