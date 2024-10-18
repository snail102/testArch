package com.example.tabsecondimpl.di

import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelAssistedFactory
import com.example.di.viewModel.ViewModelAssistedFactoryKey
import com.example.di.viewModel.ViewModelFactoryModule
import com.example.di.viewModel.ViewModelKey
import com.example.tabsecondimpl.presentation.TabSecondTestViewModel
import com.example.tabsecondimpl.presentation.TabSecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface TabSecondViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TabSecondViewModel::class)
    fun bindsTabSecondViewModel(vm: TabSecondViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelAssistedFactoryKey(TabSecondTestViewModel::class)
    fun bindsTabSecondTestViewModelFactory(factory: TabSecondTestViewModel.Factory): ViewModelAssistedFactory<*>
}
