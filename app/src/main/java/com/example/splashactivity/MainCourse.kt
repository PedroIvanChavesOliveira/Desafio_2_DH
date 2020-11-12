package com.example.splashactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainCourse(val mainCourseImage:String,
                 val mainCourseName: String,
                 val mainCourseDescription: String
): Parcelable {}