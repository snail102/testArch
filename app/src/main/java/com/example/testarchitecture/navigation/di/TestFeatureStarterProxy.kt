package com.example.testarchitecture.navigation.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.testapi.di.TestFeatureStarter
import com.example.testimpl.di.TestComponentHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestFeatureStarterProxy @Inject constructor() : TestFeatureStarter {
    @Composable
    override fun AddTestScreen(entry: NavBackStackEntry) {
        TestComponentHolder.get().testFeatureStarter.AddTestScreen(
            entry
        )
    }
}
