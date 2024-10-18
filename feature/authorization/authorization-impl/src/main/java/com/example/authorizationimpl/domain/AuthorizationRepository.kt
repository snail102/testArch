package com.example.authorizationimpl.domain

interface AuthorizationRepository {
    suspend fun signIn(): Result<Unit>
}
