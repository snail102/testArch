package com.example.tabsecondimpl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testapi.navigation.TestScreenDestination

@Composable
fun TabSecondScreen(
    viewModel: TabSecondViewModel,
    testViewModel: TabSecondTestViewModel,
    toTestFeature: (TestScreenDestination) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column {
        Text("external value in repository $state")
        Button(
            onClick = {
                toTestFeature(TestScreenDestination(key = state.toString()))
            }
        ) {
            Text(
                "to test feature"
            )
        }

        Button(
            onClick = {
                viewModel.increase()
            }
        ) {
            Text(
                "increase"
            )
        }
    }
}
