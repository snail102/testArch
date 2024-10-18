package com.example.data.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate
import com.example.domain.DomainApi

object DataComponentHolder : ComponentHolder<DomainApi, DataDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
        DomainApi,
        DataDependencies,
        DataComponent
        >(
        componentName = "DataComponentHolder",
        componentFactory = { dependencies: DataDependencies ->
            DataComponent.initAndGet(dependencies)
        }
    )

    override var dependencyProvider: (() -> DataDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): DomainApi = componentHolderDelegate.get()

    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): DataComponent = componentHolderDelegate.getComponentImpl()
}
