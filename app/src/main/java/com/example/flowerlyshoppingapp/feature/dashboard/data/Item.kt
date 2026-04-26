package com.example.flowerlyshoppingapp.feature.dashboard.data

data class Item(
    val itemName: String = "",
    val itemDescription: String = "",
    val itemImgURL: String = "",
    val category: String = "",
    val rating: Double = 0.0,
    val reviewCount: Int = 0,
    val isAvailable: Boolean = true,
    val isFavorite: Boolean = false,
    val itemPrice: Double = 0.0,
    val quantity: Int = 0
)
