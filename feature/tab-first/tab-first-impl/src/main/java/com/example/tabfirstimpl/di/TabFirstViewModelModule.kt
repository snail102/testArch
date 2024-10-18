package com.example.tabfirstimpl.di

import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelFactoryModule
import com.example.di.viewModel.ViewModelKey
import com.example.tabfirstimpl.presentation.TabFirstViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface TabFirstViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TabFirstViewModel::class)
    fun bindsTabFirstViewModel(vm: TabFirstViewModel): ViewModel
}
