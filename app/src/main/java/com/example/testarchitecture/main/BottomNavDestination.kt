package com.example.testarchitecture.main

import com.example.tabfirstapi.navigation.TabFirstScreenDestination
import com.example.tabsecondapi.navigation.TabSecondScreenDestination

sealed class BottomNavDestination(val title: String, val destination: Any) {
    data object TabFirstItem : BottomNavDestination(
        title = "1",
        destination = TabFirstScreenDestination
    )
    data object TabSecondItem : BottomNavDestination(
        title = "2",
        destination = TabSecondScreenDestination
    )
}
