package com.example.testarchitecture.navigation.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.navigation.ScreenDestination
import com.example.tabsecondapi.di.TabSecondFeatureStarter
import com.example.tabsecondimpl.di.TabSecondComponentHolder
import com.example.testapi.navigation.TestScreenDestination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TabSecondFeatureStarterProxy @Inject constructor() : TabSecondFeatureStarter {
    @Composable
    override fun AddTabSecondScreen(entry: NavBackStackEntry, toTestFeature: (ScreenDestination) -> Unit) {
        TabSecondComponentHolder.get().tabSecondFeatureStarter.AddTabSecondScreen(
            entry,
            toTestFeature
        )
    }
}
