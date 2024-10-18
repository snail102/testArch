package com.example.tabsecondimpl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.di.viewModel.ViewModelFactory
import com.example.tabsecondapi.di.TabSecondApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [TabSecondModule::class, TabSecondViewModelModule::class],
    dependencies = [TabSecondDependencies::class]
)
@Singleton
internal interface TabSecondComponent : TabSecondApiFeatureToLifecycle {
    val viewModelFactory: ViewModelProvider.Factory
    val viewModelSavedStateHandleFactory: ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: TabSecondDependencies): TabSecondComponent
    }

    companion object {
        fun initAndGet(dependencies: TabSecondDependencies): TabSecondComponent {
            Log.d("DI", "create TabSecondComponent")
            return DaggerTabSecondComponent.factory().create(dependencies)
        }
    }
}
