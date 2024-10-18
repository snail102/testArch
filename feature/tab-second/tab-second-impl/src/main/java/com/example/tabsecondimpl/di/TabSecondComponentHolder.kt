package com.example.tabsecondimpl.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate
import com.example.tabsecondapi.di.TabSecondApiFeatureToLifecycle

object TabSecondComponentHolder :
    ComponentHolder<TabSecondApiFeatureToLifecycle, TabSecondDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            TabSecondApiFeatureToLifecycle,
            TabSecondDependencies,
            TabSecondComponent
            >(
            componentName = "TabSecondComponentHolder",
            componentFactory = { dependencies: TabSecondDependencies ->
                TabSecondComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> TabSecondDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): TabSecondApiFeatureToLifecycle = componentHolderDelegate.get()
    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): TabSecondComponent = componentHolderDelegate.getComponentImpl()
}
