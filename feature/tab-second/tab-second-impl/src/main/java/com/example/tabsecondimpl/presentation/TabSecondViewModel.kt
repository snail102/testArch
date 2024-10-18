package com.example.tabsecondimpl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tabsecondimpl.domain.TabSecondRepository
import javax.inject.Inject

class TabSecondViewModel @Inject constructor(private val tabSecondRepository: TabSecondRepository) :
    ViewModel() {

    val state = tabSecondRepository.state
    init {
        Log.d("TabSecond", "init viewModel $this")
    }

    fun increase() {
        tabSecondRepository.increase()
    }
}
