package com.example.testarchitecture.navigation.di

import com.example.authozationapi.di.AuthorizationFeatureStarter
import com.example.di.BaseApi
import com.example.tabfirstapi.di.TabFirstFeatureStarter
import com.example.tabsecondapi.di.TabSecondFeatureStarter
import com.example.testapi.di.TestFeatureStarter

interface NavigationApi : BaseApi {
    val authStarter: AuthorizationFeatureStarter
    val tabFirstStarter: TabFirstFeatureStarter
    val tabSecondStarter: TabSecondFeatureStarter
    val testStarter: TestFeatureStarter
}
