package com.example.dicompose.binder

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.example.di.BaseApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BinderBaseApiImpl @Inject constructor() :
    BinderBaseApi,
    Application.ActivityLifecycleCallbacks {
    private val entryLifecycleEventObservers =
        mutableMapOf<String, EntryLifecycleEventObserver>()

    private var isCanBeRemoved = true

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {}

    override fun onActivityStarted(p0: Activity) {}

    override fun onActivityResumed(p0: Activity) {}

    override fun onActivityPaused(p0: Activity) {}

    override fun onActivityStopped(p0: Activity) {}

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}

    override fun onActivityPreDestroyed(activity: Activity) {
        if (activity.isChangingConfigurations) {
            isCanBeRemoved = false
        }
        Log.d(
            "DI",
            "$activity::onActivityPreDestroyed() isChangingConfigurations = ${activity.isChangingConfigurations}"
        )
    }

    override fun onActivityDestroyed(p0: Activity) {
        isCanBeRemoved = true
        Log.d("DI", "$p0::onActivityDestroyed()")
    }

    override fun bind(entryId: String, api: BaseApi): LifecycleEventObserver =
        entryLifecycleEventObservers.getOrPut(entryId) {
            EntryLifecycleEventObserver(entryId, api, ::removeEntryLifecycleEventObserver)
        }

    private fun removeEntryLifecycleEventObserver(entryId: String) {
        if (isCanBeRemoved) {
            Log.d("DI", "removed entryId = $entryId")
            entryLifecycleEventObservers.remove(entryId)
        }
    }

    private class EntryLifecycleEventObserver(
        private val entryId: String,
        private val api: BaseApi,
        private val removedObserver: (entryId: String) -> Unit
    ) : LifecycleEventObserver {
        init {
            Log.d("DI", "LifecycleEventObserver::init($entryId) $this")
        }

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                Log.d("DI", "entryId = $entryId -> event = $event")
                removedObserver(entryId)
            }
        }
    }
}
