package com.mchzainuri.anmp.view

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mchzainuri.anmp.R
import com.mchzainuri.anmp.databinding.FragmentCreateHabitBinding
import com.mchzainuri.anmp.viewmodel.HabitViewModel

class CreateHabitFragment : Fragment(R.layout.fragment_create_habit) {
    private var _binding: FragmentCreateHabitBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HabitViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCreateHabitBinding.bind(view)

        // Pilihan dropdown Spinner untuk Ikon
        val iconOptions = listOf("Water", "Fitness", "Read", "Meditation")
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, iconOptions)
        binding.spinnerIcon.adapter = spinnerAdapter

        binding.btnCreateHabit.setOnClickListener {
            val name = binding.etHabitName.text.toString().trim()
            val desc = binding.etDescription.text.toString().trim()
            val goalStr = binding.etGoal.text.toString().trim()
            val unit = binding.etUnit.text.toString().trim()

            if (name.isEmpty() || desc.isEmpty() || goalStr.isEmpty() || unit.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pemetaan ikon berdasarkan pilihan Spinner
            val iconResId = when (binding.spinnerIcon.selectedItem.toString()) {
                "Water" -> R.drawable.ic_water
                "Fitness" -> R.drawable.ic_fitness
                "Read" -> R.drawable.ic_book
                else -> R.drawable.ic_meditation
            }

            viewModel.addHabit(name, desc, goalStr.toInt(), unit, iconResId)
            findNavController().popBackStack() // Kembali ke Dashboard
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}