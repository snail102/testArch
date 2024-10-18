package com.example.testimpl.data

import android.util.Log
import com.example.testimpl.domain.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor() : TestRepository {

    init {
        Log.d("test", "init TestRepository $this")
    }
}
