package com.example.testarchitecture.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.authozationapi.navigation.AuthorizationScreenDestination
import com.example.tabfirstapi.navigation.TabFirstScreenDestination
import com.example.tabsecondapi.navigation.TabSecondScreenDestination
import com.example.testapi.navigation.TestScreenDestination
import com.example.testarchitecture.di.AppComponent
import com.example.testarchitecture.di.AppComponentHolder
import com.example.testarchitecture.ui.theme.TestArchitectureTheme
import com.example.utilscompose.rememberFlowWithLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNav()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNav() {
    val navController = rememberNavController()
    val component: AppComponent = remember { AppComponentHolder.getComponent() }

    val viewModel: MainViewModel = viewModel(factory = component.viewModelFactory)
    val event = rememberFlowWithLifecycle(viewModel.event)

    LaunchedEffect(event) {
        event.collect { event ->
            when (event) {
                MainEvent.NavigateToAuthorization -> {
                    navController.navigate(AuthorizationScreenDestination)
                }

                MainEvent.NavigateToHome -> {
                    navController.navigate(HomeScreenDestination) {
                        popUpTo(
                            navController.graph.findStartDestination().id
                        ) {
                            inclusive = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                    }
                }
            }
        }
    }

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = AuthorizationScreenDestination,
            modifier = Modifier.padding(it)
        ) {
            composable<AuthorizationScreenDestination> { entry ->
                component.navigationApi.authStarter.AddAuthorizationScreen(
                    entry = entry
                )
            }

            composable<TestScreenDestination> { entry ->
                component.navigationApi.testStarter.AddTestScreen(
                    entry = entry
                )
            }

            composable<HomeScreenDestination> {
                val items = mutableListOf(
                    BottomNavDestination.TabFirstItem,
                    BottomNavDestination.TabSecondItem
                )
                val navController2 = rememberNavController()
                val navBackStackEntry by navController2.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            items.forEach { item ->
                                NavigationBarItem(
                                    selected = false,
//                                    currentDestination?.hierarchy?.any {
//                                        it.route == item.toString()
//                                    } ==
//                                        true,
                                    onClick = {
                                        navController2.navigate(item.destination) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(
                                                navController2.graph.findStartDestination().id
                                            ) {
                                                saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true
                                            // Restore state when reselecting a previously selected item
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                    },
                                    label = { Text(text = item.title) }
                                )
                            }
                        }
                    }
                ) {
                    NavHost(
                        navController = navController2,
                        startDestination = TabFirstScreenDestination
                    ) {
                        composable<TabFirstScreenDestination> { entry ->
                            component.navigationApi.tabFirstStarter.AddTabFirstScreen(
                                entry = entry
                            )
                        }

                        composable<TabSecondScreenDestination> { entry ->
                            component.navigationApi.tabSecondStarter.AddTabSecondScreen(
                                entry = entry,
                                toTestFeature = {
                                    navController.navigate(it)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
