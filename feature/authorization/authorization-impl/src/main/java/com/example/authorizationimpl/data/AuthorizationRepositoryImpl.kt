package com.example.authorizationimpl.data

import android.util.Log
import com.example.authorizationimpl.domain.AuthorizationRepository
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor() : AuthorizationRepository {
    override suspend fun signIn(): Result<Unit> = Result.success(Unit)

    init {
        Log.d("Authorization", "init repository $this")
    }
}
