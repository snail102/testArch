package com.example.tabfirstimpl.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabFirstScreen(viewModel: TabFirstViewModel? = null) {
    Scaffold {
        Box {
            Text("first tab screen")
        }
    }
}
