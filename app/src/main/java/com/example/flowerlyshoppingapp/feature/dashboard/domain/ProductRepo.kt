package com.example.flowerlyshoppingapp.feature.dashboard.domain

import com.example.flowerlyshoppingapp.feature.dashboard.data.Item

interface ProductRepo {
    fun getProduct(callback: (List<Item>) -> Unit)
}