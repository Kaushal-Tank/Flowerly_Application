package com.example.flowerlyshoppingapp.feature.dashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowerlyshoppingapp.feature.dashboard.data.Item
import com.example.flowerlyshoppingapp.feature.dashboard.data.ProductRepoImp

class HomeViewModel : ViewModel() {
    private val repo = ProductRepoImp()

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    fun loadItems() {
        repo.getProduct { list ->
            _items.postValue(list)
        }
    }
}