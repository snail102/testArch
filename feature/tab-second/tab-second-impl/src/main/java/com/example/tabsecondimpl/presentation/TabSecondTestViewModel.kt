package com.example.tabsecondimpl.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TabSecondTestViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle
): ViewModel() {

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<TabSecondTestViewModel>
}