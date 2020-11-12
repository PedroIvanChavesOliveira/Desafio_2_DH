package com.example.splashactivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_menu.view.*
import kotlinx.android.synthetic.main.main_card_list_item.view.*

class ViewHolderRestaurant(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(restaurant: Restaurant, onItemClicked: (Int) -> Unit) = with(itemView) {
        Glide.with(itemView.context).load(restaurant.restaurantImage).into(ivCardPhoto)

        tvCardTitle.text = restaurant.restaurantName
        tvCardSubtitle.text = restaurant.restaurantAdress
        tvCardOperation.text = restaurant.restaurantOperation

        vgCardListRestaurant.setOnClickListener {
            onItemClicked(this@ViewHolderRestaurant.adapterPosition)
        }
    }
}