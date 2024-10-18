package com.example.testarchitecture.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate

object AppComponentHolder : ComponentHolder<AppApi, AppDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            AppApi,
            AppDependencies,
            AppComponent
            >(
            componentName = "AppComponentHolder",
            componentFactory = { dependencies: AppDependencies ->
                AppComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> AppDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AppApi = componentHolderDelegate.get()
    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): AppComponent = componentHolderDelegate.getComponentImpl()
}
