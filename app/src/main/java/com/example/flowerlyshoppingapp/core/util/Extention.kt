package com.example.flowerlyshoppingapp.core.util

import android.app.Activity
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.flowerlyshoppingapp.R

fun Fragment.toast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun String.isValidEmailFormate(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun Fragment.loadFragment(containerID: Int, fragment: Fragment) {
    parentFragmentManager
        .beginTransaction()
        .replace(containerID, fragment)
        .commit()
}

fun AppCompatActivity.loadFragment(containerID: Int, fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(containerID, fragment)
        .commit()
}