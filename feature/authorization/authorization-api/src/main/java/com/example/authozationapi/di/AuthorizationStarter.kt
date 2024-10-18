package com.example.authozationapi.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface AuthorizationFeatureStarter {
    @Composable
    fun AddAuthorizationScreen(entry: NavBackStackEntry)
}
