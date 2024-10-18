package com.example.testimpl.data

import android.util.Log
import com.example.testapi.domain.ExternalRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExternalRepositoryImpl @Inject constructor() : ExternalRepository {

    init {
        Log.d("test", "init ExternalRepository $this")
    }

    private val _state = MutableStateFlow(0)

    override val state: StateFlow<Int>
        get() = _state.asStateFlow()

    override fun increase() {
        _state.update {
            it + 1
        }
    }

    override suspend fun getValue(): Result<Int> = Result.success(1)
}
