package com.example.testapi.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface TestFeatureStarter {
    @Composable
    fun AddTestScreen(entry: NavBackStackEntry)
}
