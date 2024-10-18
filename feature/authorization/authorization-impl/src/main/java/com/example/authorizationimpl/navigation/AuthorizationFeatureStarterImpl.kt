package com.example.authorizationimpl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.authorizationimpl.di.AuthorizationComponent
import com.example.authorizationimpl.di.AuthorizationComponentHolder
import com.example.authorizationimpl.presentation.AuthorizationScreen
import com.example.authorizationimpl.presentation.AuthorizationViewModel
import com.example.authozationapi.di.AuthorizationFeatureStarter
import com.example.dicompose.binder.BindApiToEntryLifecycle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationFeatureStarterImpl @Inject constructor() : AuthorizationFeatureStarter {
    @Composable
    override fun AddAuthorizationScreen(entry: NavBackStackEntry) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = AuthorizationComponentHolder
        ) {
            val component: AuthorizationComponent =
                remember { AuthorizationComponentHolder.getComponent() }
            val viewModel: AuthorizationViewModel = viewModel(factory = component.viewModelFactory)
            AuthorizationScreen(viewModel)
        }
    }
}
