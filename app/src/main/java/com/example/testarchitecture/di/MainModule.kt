package com.example.testarchitecture.di

import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelFactoryModule
import com.example.di.viewModel.ViewModelKey
import com.example.testarchitecture.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(vm: MainViewModel): ViewModel
}
