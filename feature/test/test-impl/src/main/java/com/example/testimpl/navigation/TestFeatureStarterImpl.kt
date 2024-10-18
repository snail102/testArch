package com.example.testimpl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.dicompose.binder.BindApiToEntryLifecycle
import com.example.dicompose.di.daggerSavedStateHandleViewModel
import com.example.testapi.di.TestFeatureStarter
import com.example.testimpl.di.TestComponent
import com.example.testimpl.di.TestComponentHolder
import com.example.testimpl.presentation.TestScreen
import com.example.testimpl.presentation.TestViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestFeatureStarterImpl @Inject constructor() : TestFeatureStarter {
    @Composable
    override fun AddTestScreen(entry: NavBackStackEntry) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = TestComponentHolder
        ) {
            val component: TestComponent =
                remember { TestComponentHolder.getComponent() }
            val viewModel: TestViewModel =
                daggerSavedStateHandleViewModel(component.viewModelSavedStateHandleFactory)
            TestScreen(viewModel)
        }
    }
}
