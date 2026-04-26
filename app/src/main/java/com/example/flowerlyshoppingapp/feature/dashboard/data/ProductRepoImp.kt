package com.example.flowerlyshoppingapp.feature.dashboard.data

import com.example.flowerlyshoppingapp.core.firebase.FirebaseConnection
import com.example.flowerlyshoppingapp.core.util.Constant
import com.example.flowerlyshoppingapp.feature.dashboard.domain.ProductRepo

class ProductRepoImp : ProductRepo {

    private val db = FirebaseConnection.firestore

    override fun getProduct(callback: (List<Item>) -> Unit) {
        db.collection(Constant.ITEM_COLLECTION)
            .addSnapshotListener { snapshots, error ->
                if (error != null) return@addSnapshotListener

                val list = mutableListOf<Item>()

                snapshots?.documents?.forEach {
                    val item = it.toObject(Item::class.java)
                    item?.let { list.add(it) }
                }
                callback(list)
            }
    }
}