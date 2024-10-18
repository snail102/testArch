package com.example.authorizationimpl.di

import androidx.lifecycle.ViewModel
import com.example.authorizationimpl.presentation.AuthorizationViewModel
import com.example.di.viewModel.ViewModelFactoryModule
import com.example.di.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface AuthorizationViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindsAuthorizationViewModel(vm: AuthorizationViewModel): ViewModel
}
