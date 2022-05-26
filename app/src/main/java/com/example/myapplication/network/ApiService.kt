package com.example.myapplication.network

import com.example.myapplication.data.User
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users")
    suspend fun register(@Body user: User): User


}