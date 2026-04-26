package com.example.flowerlyshoppingapp.core.util

import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flowerlyshoppingapp.R


fun setupTopBar(
    activity: AppCompatActivity,
    title: String? = null,
    titleRes: Int? = null,
    showBack: Boolean = false,
    showNotif: Boolean = false,
    showClose: Boolean = false
) {
    val tvTitle = activity.findViewById<TextView>(R.id.tb_title)
    val btnBack = activity.findViewById<ImageButton>(R.id.btn_back)
    val btnNotif = activity.findViewById<ImageButton>(R.id.btn_notification)
    val btnClose = activity.findViewById<ImageButton>(R.id.btn_close)

    when {
        titleRes != null -> tvTitle.setText(titleRes)
        title != null -> tvTitle.text = title
    }

    btnBack.visibility = if (showBack) View.VISIBLE else View.GONE
    btnNotif.visibility = if (showNotif) View.VISIBLE else View.GONE
    btnClose.visibility = if (showClose) View.VISIBLE else View.GONE

    btnBack.setOnClickListener {
        // TODO back to previous fragment
    }
    btnNotif.setOnClickListener {
        // TODO go to notification fragment
    }
    btnClose.setOnClickListener {
        // TODO back to cart fragment
    }
}

fun showSearchbar(activity: AppCompatActivity, show: Boolean) {
    val searchbar = activity.findViewById<LinearLayout>(R.id.dashboard_search_bar)
    searchbar.visibility = if (show) View.VISIBLE else View.GONE
}