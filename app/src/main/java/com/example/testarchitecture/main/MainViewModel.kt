package com.example.testarchitecture.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UserRepository
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow

class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _event = Channel<MainEvent>(capacity = Channel.CONFLATED)
    val event = _event.receiveAsFlow()

    init {
        userRepository.isAuthUserFlow.onEach {
            if (it) {
                _event.send(MainEvent.NavigateToHome)
            } else {
                _event.send(MainEvent.NavigateToAuthorization)
            }
        }.launchIn(viewModelScope)
    }
}
