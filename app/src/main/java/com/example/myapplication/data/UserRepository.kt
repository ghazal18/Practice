package com.example.myapplication.data

class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

    suspend fun register(user: User) :User{
        val user = userRemoteDataSource.register(user)
        return user
    }
}