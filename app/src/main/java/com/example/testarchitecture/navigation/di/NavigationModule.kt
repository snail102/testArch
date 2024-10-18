package com.example.testarchitecture.navigation.di

import com.example.authozationapi.di.AuthorizationFeatureStarter
import com.example.tabfirstapi.di.TabFirstFeatureStarter
import com.example.tabsecondapi.di.TabSecondFeatureStarter
import com.example.testapi.di.TestFeatureStarter
import dagger.Binds
import dagger.Module

@Module
internal interface NavigationModule {
    @Binds
    fun bindAuthorizationFeatureStarterProxyAuthorizationFeatureStarter(
        featureStarterProxy: AuthorizationFeatureStarterProxy
    ): AuthorizationFeatureStarter

    @Binds
    fun bindTabFirstFeatureStarterProxyTabFirstFeatureStarter(
        featureStarterProxy: TabFirstFeatureStarterProxy
    ): TabFirstFeatureStarter

    @Binds
    fun bindTabSecondFeatureStarterProxyTabSecondFeatureStarter(
        featureStarterProxy: TabSecondFeatureStarterProxy
    ): TabSecondFeatureStarter

    @Binds
    fun bindTestFeatureStarterProxyTestFeatureStarter(
        featureStarterProxy: TestFeatureStarterProxy
    ): TestFeatureStarter
}
