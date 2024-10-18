package com.example.domain

import com.example.di.BaseApi

interface DomainApi : BaseApi {
    val userRepository: UserRepository
}
