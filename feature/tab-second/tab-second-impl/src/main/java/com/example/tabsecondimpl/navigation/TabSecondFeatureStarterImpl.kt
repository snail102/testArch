package com.example.tabsecondimpl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.dicompose.binder.BindApiToEntryLifecycle
import com.example.dicompose.di.daggerSavedStateHandleViewModel
import com.example.navigation.ScreenDestination
import com.example.tabsecondapi.di.TabSecondFeatureStarter
import com.example.tabsecondimpl.di.TabSecondComponent
import com.example.tabsecondimpl.di.TabSecondComponentHolder
import com.example.tabsecondimpl.presentation.TabSecondScreen
import com.example.tabsecondimpl.presentation.TabSecondTestViewModel
import com.example.tabsecondimpl.presentation.TabSecondViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TabSecondFeatureStarterImpl @Inject constructor() : TabSecondFeatureStarter {
    @Composable
    override fun AddTabSecondScreen(entry: NavBackStackEntry, toTestFeature: (ScreenDestination) -> Unit) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = TabSecondComponentHolder
        ) {
            val component: TabSecondComponent =
                remember { TabSecondComponentHolder.getComponent() }
            val viewModel: TabSecondViewModel = viewModel(factory = component.viewModelFactory)
            val testViewModel: TabSecondTestViewModel = daggerSavedStateHandleViewModel(
                viewModelFactory = component.viewModelSavedStateHandleFactory
            )
            TabSecondScreen(
                viewModel = viewModel,
                testViewModel = testViewModel,
                toTestFeature = toTestFeature
            )
        }
    }
}
