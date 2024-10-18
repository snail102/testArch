package com.example.testimpl.di

import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelAssistedFactory
import com.example.di.viewModel.ViewModelAssistedFactoryKey
import com.example.di.viewModel.ViewModelFactoryModule
import com.example.di.viewModel.ViewModelKey
import com.example.testimpl.presentation.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface TestViewModelModule {

    @Binds
    @IntoMap
    @ViewModelAssistedFactoryKey(TestViewModel::class)
    fun bindsTabSecondTestViewModelFactory(factory: TestViewModel.Factory): ViewModelAssistedFactory<*>
}
