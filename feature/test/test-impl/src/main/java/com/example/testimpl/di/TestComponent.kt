package com.example.testimpl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.di.viewModel.ViewModelFactory
import com.example.testapi.di.TestApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [TestModule::class, TestViewModelModule::class],
    dependencies = [TestDependencies::class]
)
@Singleton
internal interface TestComponent : TestApiFeatureToLifecycle {
    //val viewModelFactory: ViewModelProvider.Factory
    val viewModelSavedStateHandleFactory: ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(dependencies: TestDependencies): TestComponent
    }

    companion object {
        fun initAndGet(dependencies: TestDependencies): TestComponent {
            Log.d("DI", "create TestComponent")
            return DaggerTestComponent.factory().create(dependencies)
        }
    }
}
