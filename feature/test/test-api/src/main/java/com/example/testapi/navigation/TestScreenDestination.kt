package com.example.testapi.navigation

import com.example.navigation.ScreenDestination
import kotlinx.serialization.Serializable

@Serializable
data class TestScreenDestination(
    val key: String
): ScreenDestination
