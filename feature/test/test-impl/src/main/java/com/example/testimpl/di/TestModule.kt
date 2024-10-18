package com.example.testimpl.di

import com.example.testapi.di.TestFeatureStarter
import com.example.testapi.domain.ExternalRepository
import com.example.testimpl.data.ExternalRepositoryImpl
import com.example.testimpl.data.TestRepositoryImpl
import com.example.testimpl.domain.TestRepository
import com.example.testimpl.navigation.TestFeatureStarterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface TestModule {
    @Binds
    fun bindFeatureStarterImpTestFeatureStarter(
        featureStarterImpl: TestFeatureStarterImpl
    ): TestFeatureStarter

    @Binds
    fun bindTestRepository(impl: TestRepositoryImpl): TestRepository

    @Binds
    @Singleton
    fun bindExternalRepository(impl: ExternalRepositoryImpl): ExternalRepository
}
