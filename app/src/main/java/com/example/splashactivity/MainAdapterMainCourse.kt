package com.example.splashactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapterMainCourse (
    private val mainCourseList: List<MainCourse>,
    private val onItemClicked: (Int) -> Unit
): RecyclerView.Adapter<ViewHolderMainCourse>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMainCourse {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_course_item, parent, false)
        return ViewHolderMainCourse(view)
    }

    override fun getItemCount(): Int {
        return mainCourseList.size
    }

    override fun onBindViewHolder(holder: ViewHolderMainCourse, position: Int) {
        holder.bind(mainCourseList[position], onItemClicked)
    }

}