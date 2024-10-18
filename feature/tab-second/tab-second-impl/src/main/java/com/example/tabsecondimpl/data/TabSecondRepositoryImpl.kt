package com.example.tabsecondimpl.data

import com.example.tabsecondimpl.domain.TabSecondRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TabSecondRepositoryImpl @Inject constructor(
    // private val externalRepository: ExternalRepository
) : TabSecondRepository {
    init {
        // Log.d("TabSecond", "init repository $this externalRepository $externalRepository")
    }

    private val _state: MutableStateFlow<Int> = MutableStateFlow(0)

    override val state: StateFlow<Int>
        get() = _state

    override fun increase() {
        _state.update {
            it + 1
        }
    }
}
