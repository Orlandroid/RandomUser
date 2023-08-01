package com.example.domain

import com.example.domain.entities.remote.RandomUserResponse


interface RemoteDataSource {

    suspend fun getRandomUser(): RandomUserResponse
}