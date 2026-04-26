package com.example.flowerlyshoppingapp.feature.auth.presentation.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.flowerlyshoppingapp.R
import com.example.flowerlyshoppingapp.core.firebase.FirebaseConnection
import com.example.flowerlyshoppingapp.core.util.isInternetOn
import com.example.flowerlyshoppingapp.feature.dashboard.presentation.ui.DashboardActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val auth = FirebaseConnection.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh)


        if (isInternetOn(this)) {
            val user = auth.currentUser
            if (user != null) {
                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(this, DashboardActivity::class.java)
                )
            } else {
                startActivity(
                    Intent(this, AuthActivity::class.java)
                )
            }
            finish()
        } else {
            Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show()
            startActivity(
                Intent(this, AuthActivity::class.java)
            )
        }


    }


}