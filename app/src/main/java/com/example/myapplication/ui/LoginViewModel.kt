package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(val userRepository: UserRepository) : ViewModel() {
    val login = MutableLiveData<Boolean>()
    fun getUser(id: String, password: Int) {
        viewModelScope.launch {
            val user = userRepository.getUser(id)
            if (password == user.password) {
                login.value = true
            } else {
                login.value = false
            }
        }
    }
}