package com.example.data.remote


import com.example.domain.entities.remote.RandomUserResponse
import retrofit2.http.GET


interface Api {

    @GET("api/")
    suspend fun getRandomUser(): RandomUserResponse

}