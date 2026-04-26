package com.example.flowerlyshoppingapp.feature.auth.domain

import com.example.flowerlyshoppingapp.core.firebase.FirebaseConnection

private val auth = FirebaseConnection.auth

interface AuthRepository {
    suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Result<Unit>

    suspend fun loginUser(
        email: String,
        password: String
    ): Result<Unit>
}