package com.example.tabfirstimpl.presentation

import androidx.lifecycle.ViewModel
import com.example.tabfirstimpl.domain.TabFirstRepository
import javax.inject.Inject

class TabFirstViewModel @Inject constructor(private val tabFirstRepository: TabFirstRepository) :
    ViewModel()
