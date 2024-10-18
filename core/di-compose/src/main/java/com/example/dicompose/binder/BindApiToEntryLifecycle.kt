package com.example.dicompose.binder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import com.example.di.BaseApi
import com.example.di.BaseDependencies
import com.example.di.ComponentHolder

@Composable
inline fun <reified CH : ComponentHolder<out BaseApi, out BaseDependencies>> BindApiToEntryLifecycle(
    entry: NavBackStackEntry,
    ch: CH,
    content: @Composable () -> Unit
) {
    val api = remember { ch.get() }
    checkNotNull(api as? BinderBaseApiToLifecycle) {
        ClassCastException("$api in not implement BinderBaseApiToLifecycle")
    }.run {
        val lifecycleEventObserver =
            remember {
                binderBaseApi.bind(entry.id, api)
            }
        entry.lifecycle.addObserver(lifecycleEventObserver)
        content()
    }
}
