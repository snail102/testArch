package com.example.authorizationimpl.di

import com.example.authozationapi.di.AuthorizationApiFeatureToLifecycle
import com.example.di.ComponentHolder
import com.example.di.ComponentHolderDelegate

object AuthorizationComponentHolder :
    ComponentHolder<AuthorizationApiFeatureToLifecycle, AuthorizationDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<
            AuthorizationApiFeatureToLifecycle,
            AuthorizationDependencies,
            AuthorizationComponent
            >(
            componentName = "AuthorizationComponentHolder",
            componentFactory = { dependencies: AuthorizationDependencies ->
                AuthorizationComponent.initAndGet(dependencies)
            }
        )

    override var dependencyProvider: (() -> AuthorizationDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AuthorizationApiFeatureToLifecycle = componentHolderDelegate.get()

    override fun reset() = componentHolderDelegate.reset()

    internal fun getComponent(): AuthorizationComponent = componentHolderDelegate.getComponentImpl()
}
