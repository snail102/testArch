package com.example.tabfirstimpl.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate
import com.example.tabfirstapi.di.TabFirstApiFeatureToLifecycle

object TabFirstComponentHolder :
    ComponentHolder<TabFirstApiFeatureToLifecycle, TabFirstDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            TabFirstApiFeatureToLifecycle,
            TabFirstDependencies,
            TabFirstComponent
            >(
            componentName = "TabFirstComponentHolder",
            componentFactory = { dependencies: TabFirstDependencies ->
                TabFirstComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> TabFirstDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): TabFirstApiFeatureToLifecycle = componentHolderDelegate.get()

    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): TabFirstComponent = componentHolderDelegate.getComponentImpl()
}
