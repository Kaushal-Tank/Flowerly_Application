package com.example.flowerlyshoppingapp.feature.auth.domain

class SigningUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(
        firstName: String, lastName: String, email: String, password: String
    ): Result<Unit> {
        return repo.registerUser(
            firstName, lastName, email, password
        )
    }
}