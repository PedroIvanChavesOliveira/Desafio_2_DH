package com.example.splashactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapterRestaurant(
    private val restaurantList: List<Restaurant>,
    private val onItemClicked: (Int) -> Unit
): RecyclerView.Adapter<ViewHolderRestaurant>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRestaurant {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_card_list_item, parent, false)
        return ViewHolderRestaurant(view)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: ViewHolderRestaurant, position: Int) {
        holder.bind(restaurantList[position], onItemClicked)
    }
}

