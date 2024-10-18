package com.example.testimpl.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreen(viewModel: TestViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold {
        Column {
            Text("external value in repository $state")
        }
        Box {
            Text("test  screen")
        }

        Button(
            onClick = {
                viewModel.increase()
            }
        ) {
            Text("increase")
        }
    }
}
