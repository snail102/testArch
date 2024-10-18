package com.example.authorizationimpl.di

import com.example.authorizationimpl.data.AuthorizationRepositoryImpl
import com.example.authorizationimpl.domain.AuthorizationRepository
import com.example.authorizationimpl.navigation.AuthorizationFeatureStarterImpl
import com.example.authozationapi.di.AuthorizationFeatureStarter
import dagger.Binds
import dagger.Module

@Module
interface AuthorizationModule {
    @Binds
    fun bindFeatureStarterImplAuthorizationFeatureStarter(
        featureStarterImpl: AuthorizationFeatureStarterImpl
    ): AuthorizationFeatureStarter

    @Binds
    fun bindAuthorizationRepository(impl: AuthorizationRepositoryImpl): AuthorizationRepository
}
