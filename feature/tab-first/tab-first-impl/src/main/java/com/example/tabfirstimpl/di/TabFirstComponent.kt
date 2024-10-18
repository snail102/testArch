package com.example.tabfirstimpl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.tabfirstapi.di.TabFirstApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [TabFirstM::class, TabFirstViewModelModule::class],
    dependencies = [TabFirstDependencies::class]
)
@Singleton
internal interface TabFirstComponent : TabFirstApiFeatureToLifecycle {
    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: TabFirstDependencies): TabFirstComponent
    }

    companion object {
        fun initAndGet(dependencies: TabFirstDependencies): TabFirstComponent {
            Log.d("DI", "create TabFirstComponent")
            return DaggerTabFirstComponent.factory().create(dependencies)
        }
    }
}
