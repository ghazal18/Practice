package com.example.myapplication.data

import com.example.myapplication.network.ApiService

class UserRemoteDataSource(val apiService: ApiService) {
    suspend fun register(user:User):User{
        return apiService.register(user)
    }

}