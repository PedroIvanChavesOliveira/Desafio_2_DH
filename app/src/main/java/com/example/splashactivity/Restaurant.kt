package com.example.splashactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Restaurant(val restaurantImage: String,
                 val restaurantName: String,
                 val restaurantAdress: String,
                 val restaurantOperation: String,
                 val restaurantList: List<MainCourse>
): Parcelable {}