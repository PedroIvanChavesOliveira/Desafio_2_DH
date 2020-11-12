package com.example.splashactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.splashactivity.RestaurantMenuActivity.Companion.KEY_MEAL_POSITION
import kotlinx.android.synthetic.main.activity_meal.*

class MealActivity : AppCompatActivity() {
    private var mainCourse: MainCourse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        mainCourse = intent.getParcelableExtra(KEY_MEAL_POSITION)

        supportActionBar?.hide()
        startComponents()

        ivArrowBackMeal.setOnClickListener {
            finish()
        }
    }

    private fun startComponents() {
        Glide.with(this).load(mainCourse?.mainCourseImage).into(ivMeal)

        tvMealName.text = mainCourse?.mainCourseName
        tvMealDescription.text = mainCourse?.mainCourseDescription
    }
}