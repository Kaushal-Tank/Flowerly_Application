package com.example.flowerlyshoppingapp.feature.auth.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.flowerlyshoppingapp.R
import com.example.flowerlyshoppingapp.core.util.loadFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        if (savedInstanceState == null) {
            loadFragment(R.id.auth_frame, LogInPageFragment())
        }
    }
}