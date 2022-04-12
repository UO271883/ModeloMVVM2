package com.example.modelomvvm2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.modelomvvm2.CourseApp
import com.example.modelomvvm2.databinding.FragmentNewCourseFragmentBinding
import com.example.modelomvvm2.domain.CourseViewModel
import com.example.modelomvvm2.model.Course

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewCourseFragment : Fragment() {

    private var _binding: FragmentNewCourseFragmentBinding? = null
    private val courseViewModel: CourseViewModel by viewModels {
        CourseViewModel.CourseViewModelFactory((activity?.application as CourseApp).repository)
    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewCourseFragmentBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            courseViewModel.addCourse(getData())
            Navigation.findNavController(it).popBackStack()
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getData() : Course {
        lateinit var nombre: String
        lateinit var profesor: String
        lateinit var descripcion: String
        with(binding) {
            try{
                nombre = nameEdit.text.toString()
                profesor = profesorEdit.text.toString()
                descripcion = descriptionEdit.text.toString()
            }catch (e: Exception){
                System.err.println("Introduce el nombre de la asignatura")
            }
            return Course(nombre, profesor, descripcion)

        }
    }
}