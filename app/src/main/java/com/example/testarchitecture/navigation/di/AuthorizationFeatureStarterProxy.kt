package com.example.testarchitecture.navigation.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.authorizationimpl.di.AuthorizationComponentHolder
import com.example.authozationapi.di.AuthorizationFeatureStarter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationFeatureStarterProxy @Inject constructor() : AuthorizationFeatureStarter {
    @Composable
    override fun AddAuthorizationScreen(entry: NavBackStackEntry) {
        AuthorizationComponentHolder.get().authorizationFeatureStarter.AddAuthorizationScreen(
            entry
        )
    }
}
