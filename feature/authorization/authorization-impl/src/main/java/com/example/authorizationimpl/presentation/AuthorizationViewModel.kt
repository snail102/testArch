package com.example.authorizationimpl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authorizationimpl.domain.AuthorizationRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

class AuthorizationViewModel @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) : ViewModel() {
    fun signIn() {
        viewModelScope.launch {
            authorizationRepository.signIn()
        }
    }

    init {
        Log.d("Authorization", "init viewModel $this")
    }
}
