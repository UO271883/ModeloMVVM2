package com.example.modelomvvm2.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.modelomvvm2.databinding.ListItemBinding

class CourseViewHolder(itemView: View, private val onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val itemViewBinding = ListItemBinding.bind(itemView)
    init {
        itemView.setOnClickListener{
            onItemClicked(adapterPosition)
        }
    }
    fun bind(courseName: String){
        with(itemViewBinding){
            TVAsignatura.text = courseName
        }
    }

}