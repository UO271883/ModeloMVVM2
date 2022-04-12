package com.example.modelomvvm2.domain

import androidx.lifecycle.*
import com.example.modelomvvm2.data.Repository
import com.example.modelomvvm2.model.Course

class CourseDetailsViewModel(val repository: Repository): ViewModel() {

    private val courseName = MutableLiveData<String>()
    val mCourse: LiveData<Course> = Transformations.switchMap(courseName){
        repository.getCourseByName(it).asLiveData()
    }

    fun setCourse(coursename: String){
        courseName.value = coursename
    }

    class CourseDetailsViewModelFactory(private val repository: Repository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CourseDetailsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CourseDetailsViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}