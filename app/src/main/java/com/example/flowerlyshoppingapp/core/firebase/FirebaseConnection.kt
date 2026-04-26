package com.example.flowerlyshoppingapp.core.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseConnection {
    companion object {
        val auth by lazy { FirebaseAuth.getInstance() }
        val firestore by lazy { FirebaseFirestore.getInstance() }
    }
}