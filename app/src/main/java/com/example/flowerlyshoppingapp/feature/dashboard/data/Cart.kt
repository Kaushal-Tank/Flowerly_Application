package com.example.flowerlyshoppingapp.feature.dashboard.data

data class Cart(
    val cartId: String = "",
    val itemId: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val price: Double = 0.0,
    val quantity: Int = 1,
    val userId: String = ""
)
