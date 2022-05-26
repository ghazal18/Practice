package com.example.myapplication.network

import com.example.myapplication.data.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("users")
    suspend fun register(@Body user: User): User

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): User


}