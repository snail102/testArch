package com.example.tabsecondimpl.domain

import kotlinx.coroutines.flow.StateFlow

interface TabSecondRepository {
    val state: StateFlow<Int>

    fun increase()
}
