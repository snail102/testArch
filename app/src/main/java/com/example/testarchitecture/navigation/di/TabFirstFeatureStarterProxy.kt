package com.example.testarchitecture.navigation.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.tabfirstapi.di.TabFirstFeatureStarter
import com.example.tabfirstimpl.di.TabFirstComponentHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TabFirstFeatureStarterProxy @Inject constructor() : TabFirstFeatureStarter {
    @Composable
    override fun AddTabFirstScreen(entry: NavBackStackEntry) {
        TabFirstComponentHolder.get().tabFirstFeatureStarter.AddTabFirstScreen(
            entry
        )
    }
}
