package com.example.testimpl.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate
import com.example.testapi.di.TestApiFeatureToLifecycle

object TestComponentHolder :
    ComponentHolder<TestApiFeatureToLifecycle, TestDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            TestApiFeatureToLifecycle,
            TestDependencies,
            TestComponent
            >(
            componentName = "TestComponentHolder",
            componentFactory = { dependencies: TestDependencies ->
                TestComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> TestDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): TestApiFeatureToLifecycle = componentHolderDelegate.get()
    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): TestComponent = componentHolderDelegate.getComponentImpl()
}
