package com.example.di

import android.util.Log
import java.lang.ref.WeakReference

interface BaseDependencies {
    val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
}

interface BaseApi

interface ComponentHolder<Api : BaseApi, Dependencies : BaseDependencies> {
    var dependencyProvider: (() -> Dependencies)?

    fun get(): Api

    fun reset()
}

interface BaseDependencyHolder<Dependencies : BaseDependencies> {
    val dependencies: Dependencies
}

abstract class DependencyHolder0<Dependencies : BaseDependencies> :
    BaseDependencyHolder<Dependencies> {
    abstract val block: (BaseDependencyHolder<Dependencies>) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this)
}

abstract class DependencyHolder1<Api1 : BaseApi, Dependencies : BaseDependencies>(
    private val api1: Api1
) : BaseDependencyHolder<Dependencies> {
    abstract val block: (BaseDependencyHolder<Dependencies>, Api1) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this, api1)
}

abstract class DependencyHolder2<Api1 : BaseApi, Api2 : BaseApi, Dependencies : BaseDependencies>(
    private val api1: Api1,
    private val api2: Api2
) : BaseDependencyHolder<Dependencies> {
    abstract val block: (BaseDependencyHolder<Dependencies>, Api1, Api2) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this, api1, api2)
}

abstract class DependencyHolder3<Api1 : BaseApi, Api2 : BaseApi, Api3 : BaseApi, Dependencies : BaseDependencies>(
    private val api1: Api1,
    private val api2: Api2,
    private val api3: Api3
) : BaseDependencyHolder<Dependencies> {
    abstract val block: (BaseDependencyHolder<Dependencies>, Api1, Api2, Api3) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this, api1, api2, api3)
}

class ComponentHolderDelegate<Api : BaseApi, Dependencies : BaseDependencies, Component : Api>(
    private val componentFactory: (Dependencies) -> Component,
    private val componentName: String
) : ComponentHolder<Api, Dependencies> {
    override var dependencyProvider: (() -> Dependencies)? = null

    private var componentWeakRef: WeakReference<Component>? = null

    fun getComponentImpl(): Component {
        var component: Component? = null
        synchronized(this) {
            dependencyProvider?.let { dependencyProvider ->
                component = componentWeakRef?.get()

                if (component == null) {
                    component = componentFactory(dependencyProvider())
                    Log.d("ComponentHolderDelegate", "init componentName $componentName")
                    componentWeakRef = WeakReference(component)
                } else {
                    Log.d("ComponentHolderDelegate", "is inited componentName $componentName")
                }
            }
                ?: throw IllegalStateException(
                    "dependencyProvider for component with factory $componentFactory is not initialized"
                )
        }

        return checkNotNull(component) {
            "Component holder with component factory $componentFactory is not initialized"
        }
    }

    override fun get(): Api = getComponentImpl()
    override fun reset() {
        componentWeakRef = null
    }
}
