package com.example.data.di

import android.util.Log
import com.example.domain.DomainApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [DataModule::class],
    dependencies = [DataDependencies::class]
)
@Singleton
internal interface DataComponent : DomainApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: DataDependencies): DataComponent
    }

    companion object {
        fun initAndGet(dependencies: DataDependencies): DataComponent {
            Log.d("DI", "create DataComponent")
            return DaggerDataComponent.factory().create(dependencies)
        }
    }
}
