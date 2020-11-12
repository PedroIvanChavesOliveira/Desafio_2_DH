package com.example.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    private val mealList: SetMeal = SetMeal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        startRestaurants()
    }

    private fun startRestaurants() {
        val restaurantList: MutableList<Restaurant> = mutableListOf()

        val restaurant1 = Restaurant("https://cdn.pixabay.com/photo/2016/11/18/14/05/brick-wall-1834784__340.jpg",
            "Dom Bosco",
            "Rua Paraíba, 750 - Centro, Belo Horizonte",
            "Fecha às 15:00", mealList.restaurantOne()
        )
        val restaurant2 = Restaurant("https://cdn.pixabay.com/photo/2014/09/17/20/26/restaurant-449952__340.jpg",
            "Restaurante Valentim",
            "Rua Montes Claros, 30 - Centro, Belo Horizonte",
            "Fecha às 23:00", mealList.restaurantTwo()
        )
        val restaurant3 = Restaurant("https://cdn.pixabay.com/photo/2018/08/10/21/52/restaurant-3597677__340.jpg",
            "Restaurante Porto Rico",
            "Rua Bocaiuva, 50 - Centro, Belo Horizonte",
            "Fecha às 18:00", mealList.restaurantOne()
        )
        val restaurant4 = Restaurant("https://cdn.pixabay.com/photo/2016/11/29/12/54/bar-1869656__340.jpg",
            "Cafeteria Alameda",
            "Rua da Bahia, 1100 - Centro, Belo Horizonte",
            "Fecha às 00:00", mealList.restaurantTwo()
        )
        val restaurant5 = Restaurant("https://cdn.pixabay.com/photo/2016/11/29/05/07/baked-goods-1867459__340.jpg",
            "Padaria da Esquina",
            "Rua Paraíba, 400 - Centro, Belo Horizonte",
            "Fecha às 13:00", mealList.restaurantOne()
        )
        val restaurant6 = Restaurant("https://cdn.pixabay.com/photo/2017/08/12/18/59/snack-2635035__340.jpg",
            "CowBoy Hamburgueria",
            "Rua São Paulo, 70 - Centro, Belo Horizonte",
            "Fecha às 01:00", mealList.restaurantTwo()
        )
        val restaurant7 = Restaurant("https://cdn.pixabay.com/photo/2017/10/02/22/24/pizza-2810589__340.jpg",
            "Pizzaria Dom Silvério",
            "Avenida Afonso Pena, 750 - Centro, Belo Horizonte",
            "Fecha às 02:00", mealList.restaurantOne()
        )
        val restaurant8 = Restaurant("https://cdn.pixabay.com/photo/2015/09/14/11/43/restaurant-939437__340.jpg",
            "Restaurante Serena",
            "Rua Rio de Janeiro, 10 - Centro, Belo Horizonte",
            "Fecha às 02:00", mealList.restaurantTwo()
        )
        val restaurant9 = Restaurant("https://cdn.pixabay.com/photo/2017/03/16/23/24/salad-2150548__340.jpg",
            "Saladicces",
            "Rua Antônio Veiga, 850 - Centro, Belo Horizonte",
            "Fecha às 18:00", mealList.restaurantOne()
        )
        val restaurant10 = Restaurant("https://cdn.pixabay.com/photo/2017/02/22/23/21/asian-food-2090947__340.jpg",
            "Japa Express",
            "Rua Santos Dumont, 2155 - Centro, Belo Horizonte",
            "Fecha às 01:00", mealList.restaurantTwo()
        )

        restaurantList.addAll(listOf(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5,
            restaurant6, restaurant7, restaurant8, restaurant9, restaurant10
        ))

        rvMenu.apply {
            layoutManager = LinearLayoutManager(this@MenuActivity)
            adapter = MainAdapterRestaurant(restaurantList) {
                val intent = Intent(this@MenuActivity, RestaurantMenuActivity::class.java)
                intent.putExtra(KEY_RESTAURANT, restaurantList[it])
                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_RESTAURANT = "restaurant"
    }
}