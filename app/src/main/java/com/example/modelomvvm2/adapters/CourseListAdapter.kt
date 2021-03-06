package com.example.modelomvvm2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.modelomvvm2.R
import com.example.modelomvvm2.databinding.ListItemBinding
import com.example.modelomvvm2.util.Utils


class CourseListAdapter(private val onNameSelected: (String) -> Unit): ListAdapter<String, CourseViewHolder>(Utils.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemView = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        /*val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)*/
        return CourseViewHolder(itemView.root){
            onNameSelected(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val courseName = getItem(position)
        holder.bind(courseName)
    }

}