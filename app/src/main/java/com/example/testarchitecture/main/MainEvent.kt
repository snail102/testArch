package com.example.testarchitecture.main

sealed interface MainEvent {
    data object NavigateToHome : MainEvent
    data object NavigateToAuthorization : MainEvent
}
