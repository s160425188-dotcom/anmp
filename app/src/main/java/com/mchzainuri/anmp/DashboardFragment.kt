package com.mchzainuri.anmp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mchzainuri.anmp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HabitViewModel by activityViewModels()
    private lateinit var adapter: HabitAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)

        adapter = HabitAdapter(emptyList()) { id, delta ->
            viewModel.updateProgress(id, delta)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe data dari ViewModel (MVVM)
        viewModel.habits.observe(viewLifecycleOwner) { list ->
            adapter.updateList(list)
        }

        // Navigasi ke halaman Create Habit
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_createHabitFragment)
        }

        viewModel.fetchHabits()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}