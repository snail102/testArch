package com.example.testapi.domain

import kotlinx.coroutines.flow.StateFlow

interface ExternalRepository {

    val state: StateFlow<Int>

    fun increase()

    suspend fun getValue(): Result<Int>
}
