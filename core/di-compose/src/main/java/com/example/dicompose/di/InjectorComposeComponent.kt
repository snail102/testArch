package com.example.dicompose.di

import android.util.Log
import com.example.dicompose.api.InjectorComposeApi
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [InjectorComposeDependencies::class],
    modules = [InjectorComposeModule::class]
)
@Singleton
interface InjectorComposeComponent : InjectorComposeApi {
    @Component.Factory
    interface Factory {
        fun create(dependencies: InjectorComposeDependencies): InjectorComposeComponent
    }

    companion object {
        fun initAndGet(dependencies: InjectorComposeDependencies): InjectorComposeComponent {
            Log.d("DI", "create DiComposeComponent")
            return DaggerInjectorComposeComponent.factory().create(dependencies)
        }
    }
}
