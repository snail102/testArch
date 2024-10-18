package com.example.tabsecondimpl.di

import com.example.tabsecondapi.di.TabSecondFeatureStarter
import com.example.tabsecondimpl.data.TabSecondRepositoryImpl
import com.example.tabsecondimpl.domain.TabSecondRepository
import com.example.tabsecondimpl.navigation.TabSecondFeatureStarterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface TabSecondModule {
    @Binds
    fun bindFeatureStarterImplTabSecondFeatureStarter(
        featureStarterImpl: TabSecondFeatureStarterImpl
    ): TabSecondFeatureStarter

    @Singleton
    @Binds
    fun bindAuthorizationRepository(impl: TabSecondRepositoryImpl): TabSecondRepository
}
