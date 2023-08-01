package com.example.data


import com.example.domain.LocalDataSource
import com.example.domain.RemoteDataSource
import com.example.domain.entities.remote.RandomUserResponse
import javax.inject.Inject


class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getRandomUser(): RandomUserResponse = remoteDataSource.getRandomUser()
}