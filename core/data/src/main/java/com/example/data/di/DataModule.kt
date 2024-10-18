package com.example.data.di

import com.example.data.UserRepositoryImpl
import com.example.domain.UserRepository
import dagger.Binds
import dagger.Module

@Module
internal interface DataModule {

    @Binds
    fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
