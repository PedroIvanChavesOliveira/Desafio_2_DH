package com.example.splashactivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_restaurant_menu.view.*
import kotlinx.android.synthetic.main.main_course_item.view.*

class ViewHolderMainCourse(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind (mainCourse: MainCourse, onItemClicked: (Int) -> Unit) = with(itemView) {
        Glide.with(itemView.context).load(mainCourse.mainCourseImage).into(ivCardPhotoMenu)

        tvCardTitleMenu.text = mainCourse.mainCourseName

        vgCardMainCourse.setOnClickListener {
            onItemClicked(this@ViewHolderMainCourse.adapterPosition)
        }
    }
}