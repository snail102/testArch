package com.example.data

import com.example.domain.UserRepository
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl @Inject constructor() : UserRepository {

    override val isAuthUserFlow: Flow<Boolean>
        get() = flow {
            delay(5000)
            emit(true)
        }
}
