package com.example.flowerlyshoppingapp.feature.auth.domain

class LoginUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repo.loginUser(email, password)
    }
}