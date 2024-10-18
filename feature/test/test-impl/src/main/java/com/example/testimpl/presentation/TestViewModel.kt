package com.example.testimpl.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.di.viewModel.ViewModelAssistedFactory
import com.example.testapi.domain.ExternalRepository
import com.example.testimpl.di.TestComponentHolder
import com.example.testimpl.domain.TestRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class TestViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle,
    private val testRepository: TestRepository,
    private val externalRepository: ExternalRepository
) : ViewModel() {

    val state = externalRepository.state

    init {
        Log.d("test", "init viewModel data from handle ${handle.get<String>("key")} $this testRepository $externalRepository")
    }

    fun increase() {
        externalRepository.increase()
    }

    override fun onCleared() {
        super.onCleared()
        TestComponentHolder.reset()
    }

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<TestViewModel>
}
