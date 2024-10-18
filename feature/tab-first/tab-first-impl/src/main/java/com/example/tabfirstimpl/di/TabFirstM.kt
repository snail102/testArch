package com.example.tabfirstimpl.di

import com.example.tabfirstapi.di.TabFirstFeatureStarter
import com.example.tabfirstimpl.data.TabFirstRepositoryImpl
import com.example.tabfirstimpl.domain.TabFirstRepository
import com.example.tabfirstimpl.navigation.TabFirstFeatureStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface TabFirstM {
    @Binds
    fun bindFeatureStarterImplTabFirstFeatureStarter(
        featureStarterImpl: TabFirstFeatureStarterImpl
    ): TabFirstFeatureStarter

    @Binds
    fun bindAuthorizationRepository(impl: TabFirstRepositoryImpl): TabFirstRepository
}
