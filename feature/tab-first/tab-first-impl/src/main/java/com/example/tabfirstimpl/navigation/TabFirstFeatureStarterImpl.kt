package com.example.tabfirstimpl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.dicompose.binder.BindApiToEntryLifecycle
import com.example.tabfirstapi.di.TabFirstFeatureStarter
import com.example.tabfirstimpl.di.TabFirstComponent
import com.example.tabfirstimpl.di.TabFirstComponentHolder
import com.example.tabfirstimpl.presentation.TabFirstScreen
import com.example.tabfirstimpl.presentation.TabFirstViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TabFirstFeatureStarterImpl @Inject constructor() : TabFirstFeatureStarter {
    @Composable
    override fun AddTabFirstScreen(entry: NavBackStackEntry) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = TabFirstComponentHolder
        ) {
            val component: TabFirstComponent =
                remember { TabFirstComponentHolder.getComponent() }
            val viewModel: TabFirstViewModel =
                viewModel(factory = component.viewModelFactory)
            TabFirstScreen(viewModel)
        }
    }
}
