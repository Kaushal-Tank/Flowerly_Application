package com.example.flowerlyshoppingapp.feature.dashboard.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowerlyshoppingapp.R
import com.example.flowerlyshoppingapp.feature.dashboard.data.Item

class ItemHomeAdapter(
    private var items: List<Item>
) : RecyclerView.Adapter<ItemHomeAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item = items[position]

        // Set image
        holder.img.clipToOutline = true
        Glide.with(holder.img.context)
            .load(item.itemImgURL)
            .into(holder.img)

        // Set Item name
        holder.title.text = item.itemName

        // Set Item price
        holder.price.text = item.itemPrice.toString()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Item>) {
        this.items = newList
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_name)
        val img: ImageView = itemView.findViewById(R.id.item_image)
        val price: TextView = itemView.findViewById(R.id.item_price)
    }

}