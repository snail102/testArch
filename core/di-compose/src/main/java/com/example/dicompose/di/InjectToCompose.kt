package com.example.dicompose.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.di.viewModel.ViewModelFactory

@Composable
inline fun <reified VM : ViewModel> daggerSavedStateHandleViewModel(viewModelFactory: ViewModelFactory): VM {
    return viewModel {
        val savedStateHandle = createSavedStateHandle()
        viewModelFactory.create(VM::class.java, savedStateHandle)
    }
}