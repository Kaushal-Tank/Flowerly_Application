package com.example.flowerlyshoppingapp.feature.dashboard.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.flowerlyshoppingapp.R
import com.example.flowerlyshoppingapp.core.util.loadFragment
import com.example.flowerlyshoppingapp.core.util.setupTopBar
import com.example.flowerlyshoppingapp.core.util.showSearchbar
import com.example.flowerlyshoppingapp.core.util.toast
import com.example.flowerlyshoppingapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Show top app bar and search bar
        setupTopBar(this, titleRes = R.string.flowerly, showBack = true, showNotif = true)
        showSearchbar(this, true)

        // By default, show home page
        if (savedInstanceState == null) {
            loadFragment(R.id.dashboard_main_frame, HomePageFragment())
        }

        binding.bottomNavigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    loadFragment(R.id.dashboard_main_frame, HomePageFragment())
                    toast("Home Page")
                    true
                }

                R.id.menu_shop -> {
                    // TODO add shop fragment
                    toast("Shop Page")
                    return@setOnItemSelectedListener true
                }

                R.id.menu_favorites -> {
                    // TODO add favorite fragment
                    toast("Favorite Page")
                    return@setOnItemSelectedListener true
                }

                R.id.menu_cart -> {
                    // TODO add cart fragment
                    toast("Cart Page")
                    return@setOnItemSelectedListener true
                }

                R.id.menu_account -> {
                    // TODO add account fragment
                    toast("Account Page")
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }

    }
}