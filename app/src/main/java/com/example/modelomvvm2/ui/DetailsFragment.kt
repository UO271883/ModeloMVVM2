package com.example.modelomvvm2.ui

import android.os.Bundle
import com.example.modelomvvm2.databinding.FragmentDetailsBinding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.modelomvvm2.CourseApp
import com.example.modelomvvm2.R
import com.example.modelomvvm2.domain.CourseDetailsViewModel
import androidx.lifecycle.*
import com.example.modelomvvm2.model.Course

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ASIGNATURA = ""

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val courseDetailViewModel: CourseDetailsViewModel by viewModels {
        CourseDetailsViewModel.CourseDetailsViewModelFactory((activity?.application as CourseApp).repository)
    }
    // TODO: Rename and change types of parameters
    private var courseName: String? = null
    private val observer: LiveData <Course> = courseDetailViewModel.mCourse
    val course: Course? = observer.value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            courseName = it.getString(ASIGNATURA)
        }
        courseName?.let {
            courseDetailViewModel.setCourse(it)
        }
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.TVNombre.text = course?.name.toString()
        binding.TVProfesor.text = course?.teacher.toString()
        binding.TVDescripcion.text = course?.description.toString()
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}