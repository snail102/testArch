package com.example.dicompose.di

import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate
import com.example.dicompose.api.InjectorComposeApi

object InjectorComposeComponentHolder :
    ComponentHolder<InjectorComposeApi, InjectorComposeDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            InjectorComposeApi,
            InjectorComposeDependencies,
            InjectorComposeComponent
            >(
            componentName = "InjectorComposeComponentHolder",
            componentFactory = { dependencies: InjectorComposeDependencies ->
                InjectorComposeComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> InjectorComposeDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): InjectorComposeApi = componentHolderDelegate.get()
    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): InjectorComposeComponent =
        componentHolderDelegate.getComponentImpl()
}
