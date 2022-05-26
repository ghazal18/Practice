package com.example.myapplication.data

class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) {

    suspend fun register(user: User): User {
        val user = userRemoteDataSource.register(user)
        return user
    }

    suspend fun getUser(id: String): User {
        return userRemoteDataSource.getUser(id)
    }
}