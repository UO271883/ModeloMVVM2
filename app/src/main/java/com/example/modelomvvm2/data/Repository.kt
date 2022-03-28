package com.example.modelomvvm2.data

import kotlinx.coroutines.flow.Flow
import com.example.modelomvvm2.model.Course
import com.example.modelomvvm2.model.CourseDAO

class Repository(private val courseDAO: CourseDAO) {

    fun getCoursesNames() = courseDAO.getNames()

    fun getCourseByName(coursename: String): Flow<Course> {
        return courseDAO.getCourseByName(coursename)
    }

    suspend fun insertCourse(course: Course) = courseDAO.insertCourse(course)
}