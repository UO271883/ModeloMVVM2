package com.example.modelomvvm2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.modelomvvm2.databinding.ListItemBinding

class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val itemViewBinding = ListItemBinding.bind(itemView)

    fun bind(courseName: String){
        with(itemViewBinding){
            TVAsignatura.text = courseName
        }
    }

}