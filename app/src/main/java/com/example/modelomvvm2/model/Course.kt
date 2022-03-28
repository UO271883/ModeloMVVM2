package com.example.modelomvvm2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
class Course(@PrimaryKey val name: String, val teacher: String, val description: String) {

}