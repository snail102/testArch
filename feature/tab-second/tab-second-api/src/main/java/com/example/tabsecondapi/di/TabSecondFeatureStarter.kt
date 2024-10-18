package com.example.tabsecondapi.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.navigation.ScreenDestination

interface TabSecondFeatureStarter {
    @Composable
    fun AddTabSecondScreen(entry: NavBackStackEntry, toTestFeature: (ScreenDestination) -> Unit)
}
