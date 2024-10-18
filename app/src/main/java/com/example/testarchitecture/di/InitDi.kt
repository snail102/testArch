package com.example.testarchitecture.di

import android.app.Application
import com.example.authorizationimpl.di.AuthorizationComponentHolder
import com.example.authorizationimpl.di.AuthorizationDependencies
import com.example.data.di.DataComponentHolder
import com.example.data.di.DataDependencies
import com.example.di.BaseDependencies
import com.example.di.BaseDependencyHolder
import com.example.di.DependencyHolder0
import com.example.di.DependencyHolder1
import com.example.di.DependencyHolder3
import com.example.dicompose.api.InjectorComposeApi
import com.example.dicompose.binder.BinderBaseApi
import com.example.dicompose.di.InjectorComposeComponentHolder
import com.example.dicompose.di.InjectorComposeDependencies
import com.example.domain.DomainApi
import com.example.domain.UserRepository
import com.example.tabfirstimpl.di.TabFirstComponentHolder
import com.example.tabfirstimpl.di.TabFirstDependencies
import com.example.tabsecondimpl.di.TabSecondComponentHolder
import com.example.tabsecondimpl.di.TabSecondDependencies
import com.example.testarchitecture.navigation.di.NavigationApi
import com.example.testarchitecture.navigation.di.NavigationComponentHolder
import com.example.testarchitecture.navigation.di.NavigationDependencies
import com.example.testimpl.di.TestComponentHolder
import com.example.testimpl.di.TestDependencies

object InitDi {
    internal fun init() {
        AppComponentHolder.dependencyProvider = {
            class AppComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<AppDependencies>,
                    InjectorComposeApi,
                    NavigationApi,
                    DomainApi
                ) -> AppDependencies
            ) : DependencyHolder3<InjectorComposeApi, NavigationApi, DomainApi, AppDependencies>(
                api1 = InjectorComposeComponentHolder.get(),
                api2 = NavigationComponentHolder.get(),
                api3 = DataComponentHolder.get()
            )

            AppComponentDependencyHolder {
                    dependencyHolder,
                    binderApiToEntryLifecycleApi,
                    navigationApi,
                    domainApi
                ->
                object : AppDependencies {
                    override val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
                        get() = binderApiToEntryLifecycleApi.activityLifecycleCallbacks
                    override val navigationApi: NavigationApi
                        get() = navigationApi
                    override val userRepository: UserRepository
                        get() = domainApi.userRepository
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        InjectorComposeComponentHolder.dependencyProvider = {
            class FCHSComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<InjectorComposeDependencies>
                ) -> InjectorComposeDependencies
            ) : DependencyHolder0<InjectorComposeDependencies>()

            FCHSComponentDependencyHolder { dependencyHolder ->
                object : InjectorComposeDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        NavigationComponentHolder.dependencyProvider = {
            class NavigationComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<NavigationDependencies>
                ) -> NavigationDependencies
            ) : DependencyHolder0<NavigationDependencies>()

            NavigationComponentDependencyHolder { dependencyHolder ->
                object : NavigationDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        DataComponentHolder.dependencyProvider = {
            class DataComponentDependencyHolder(
                override val block: (BaseDependencyHolder<DataDependencies>) -> DataDependencies
            ) : DependencyHolder0<DataDependencies>()

            DataComponentDependencyHolder { dependencyHolder ->
                object : DataDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        AuthorizationComponentHolder.dependencyProvider = {
            class AuthorizationComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<AuthorizationDependencies>,
                    InjectorComposeApi
                ) -> AuthorizationDependencies
            ) : DependencyHolder1<InjectorComposeApi, AuthorizationDependencies>(
                api1 = InjectorComposeComponentHolder.get()
            )

            AuthorizationComponentDependencyHolder {
                    dependencyHolder,
                    binderApiToEntryLifecycleApi
                ->
                object : AuthorizationDependencies {
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        TabFirstComponentHolder.dependencyProvider = {
            class TabFirstComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<TabFirstDependencies>,
                    InjectorComposeApi
                ) -> TabFirstDependencies
            ) : DependencyHolder1<InjectorComposeApi, TabFirstDependencies>(
                api1 = InjectorComposeComponentHolder.get()
            )

            TabFirstComponentDependencyHolder { dependencyHolder, binderApiToEntryLifecycleApi ->
                object : TabFirstDependencies {
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        TabSecondComponentHolder.dependencyProvider = {
            class TabSecondComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<TabSecondDependencies>,
                    InjectorComposeApi
                ) -> TabSecondDependencies
            ) : DependencyHolder1<InjectorComposeApi, TabSecondDependencies>(
                api1 = InjectorComposeComponentHolder.get()
            )

            TabSecondComponentDependencyHolder {
                    dependencyHolder,
                    binderApiToEntryLifecycleApi
                ->
                object : TabSecondDependencies {
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        TestComponentHolder.dependencyProvider = {
            class TestComponentDependencyHolder(
                override val block: (
                    BaseDependencyHolder<TestDependencies>,
                    InjectorComposeApi
                ) -> TestDependencies
            ) : DependencyHolder1<InjectorComposeApi, TestDependencies>(
                api1 = InjectorComposeComponentHolder.get()
            )

            TestComponentDependencyHolder { dependencyHolder, binderApiToEntryLifecycleApi ->
                object : TestDependencies {
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }
    }
}
