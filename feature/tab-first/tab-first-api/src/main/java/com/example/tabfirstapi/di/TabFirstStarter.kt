package com.example.tabfirstapi.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface TabFirstFeatureStarter {
    @Composable
    fun AddTabFirstScreen(entry: NavBackStackEntry)
}
