package com.example.testarchitecture.navigation.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate

object NavigationComponentHolder : ComponentHolder<NavigationApi, NavigationDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            NavigationApi,
            NavigationDependencies,
            NavigationComponent
            >(
            componentName = "NavigationComponentHolder",
            componentFactory = { dependencies: NavigationDependencies ->
                NavigationComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> NavigationDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): NavigationApi = componentHolderDelegate.get()

    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): NavigationComponent = componentHolderDelegate.getComponentImpl()
}
