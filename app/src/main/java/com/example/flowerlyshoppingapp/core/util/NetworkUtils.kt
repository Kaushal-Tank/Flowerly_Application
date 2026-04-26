package com.example.flowerlyshoppingapp.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


fun isInternetOn(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val network = connectivityManager.activeNetwork ?: return false
    val capability = connectivityManager.getNetworkCapabilities(network) ?: return false

    return capability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
