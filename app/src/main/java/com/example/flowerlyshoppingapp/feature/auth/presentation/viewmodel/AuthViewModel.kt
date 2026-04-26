package com.example.flowerlyshoppingapp.feature.auth.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowerlyshoppingapp.feature.auth.data.AuthRepoImpl
import com.example.flowerlyshoppingapp.feature.auth.domain.LoginUseCase
import com.example.flowerlyshoppingapp.feature.auth.domain.SigningUseCase
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repo = AuthRepoImpl()

    // Log in Items
    private val loginUseCase = LoginUseCase(repo)

    private val _loginSate = MutableLiveData<String>()
    val loginState: LiveData<String> = _loginSate

    // Sign in Items
    private val signupUseCase = SigningUseCase(repo)
    private val _signupState = MutableLiveData<String>()
    val signupState: LiveData<String> = _signupState


    /*----------  All Functions  ----------*/
    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = loginUseCase(email, password)

            if (result.isSuccess) {
                _loginSate.value = "SUCCESS"
            } else {
                _loginSate.value = "Invalid email or password !"
            }
        }
    }

    fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val result = signupUseCase(firstName, lastName, email, password)

            if (result.isSuccess){
                _signupState.value="SUCCESS"
            } else {
                _signupState.value="Failed to Registration !"
            }
        }
    }



}