package com.example.authorizationimpl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuthorizationScreen(viewModel: AuthorizationViewModel) {
    Scaffold { paddingValues ->
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Authorization")
            Button(onClick = {
                viewModel.signIn()
            }) {
                Text("Sign In")
            }
        }
    }
}
