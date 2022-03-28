package com.example.modelomvvm2

import android.app.Application
import com.example.modelomvvm2.data.Repository
import com.example.modelomvvm2.model.CourseDatabase

class CourseApp: Application() {
    val courseDatabase by lazy {
        CourseDatabase.getInstance(this)
    }
    val repository by lazy {
        Repository(courseDatabase!!.courseDao())
    }
}