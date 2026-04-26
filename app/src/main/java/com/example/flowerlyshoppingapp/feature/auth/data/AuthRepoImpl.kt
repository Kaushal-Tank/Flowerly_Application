package com.example.flowerlyshoppingapp.feature.auth.data

import com.example.flowerlyshoppingapp.core.firebase.FirebaseConnection
import com.example.flowerlyshoppingapp.feature.auth.domain.AuthRepository
import kotlinx.coroutines.tasks.await

class AuthRepoImpl : AuthRepository {

    private val auth = FirebaseConnection.auth
    private val firestore = FirebaseConnection.firestore

    override suspend fun loginUser(
        email: String, password: String
    ): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun registerUser(
        firstName: String, lastName: String, email: String, password: String
    ): Result<Unit> {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}