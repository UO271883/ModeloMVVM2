package com.example.modelomvvm2.ui

import com.example.modelomvvm2.CourseApp
import com.example.modelomvvm2.adapters.CourseListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.modelomvvm2.R
import com.example.modelomvvm2.databinding.FragmentListBinding
import com.example.modelomvvm2.domain.CourseViewModel
private const val ASIGNATURA = "asignatura"
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val courseViewModel: CourseViewModel by viewModels {
        CourseViewModel.CourseViewModelFactory((activity?.application as CourseApp).repository)
    }
    private val adapter = CourseListAdapter {
        val bundle = Bundle().apply {
            putString(ASIGNATURA,it)
        }
        findNavController().navigate(R.id.action_ListFragment_to_detailsFragment,bundle)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        courseViewModel.courseNames.observe(viewLifecycleOwner) { names ->
            names.let { adapter.submitList(names.toMutableList()) }
        }
        adapter.onCreateViewHolder(binding.root,1) // NO ENTIENDO
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}