package com.example.domain

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val isAuthUserFlow: Flow<Boolean>
}
