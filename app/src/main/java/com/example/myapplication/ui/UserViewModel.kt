package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.User
import com.example.myapplication.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository) : ViewModel() {
    val userLiveData = MutableLiveData<User>()
    fun register(userName: String, password: Int) {
        viewModelScope.launch {
            val user = userRepository.register(User("81", userName, password))
            userLiveData.value = user
        }
    }

}