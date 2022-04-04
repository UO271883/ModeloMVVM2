package com.example.modelomvvm2.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.modelomvvm2.data.Repository
import com.example.modelomvvm2.model.Course
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(val repository: Repository): ViewModel() {

    val courseNames: LiveData<List<String>> by lazy{ repository.getCoursesNames().asLiveData() }

    class CourseViewModelFactory(private val repository: Repository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CourseViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CourseViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun addCourse(course: Course): Boolean {
        CoroutineScope(Dispatchers.Default).launch {
            repository.insertCourse(course)
        }
        return true
    }
}