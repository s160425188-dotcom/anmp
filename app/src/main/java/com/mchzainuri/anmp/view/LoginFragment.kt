package com.mchzainuri.anmp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mchzainuri.anmp.R
import com.mchzainuri.anmp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            binding.tilUsername.error = null
            binding.tilPassword.error = null

            if (username == "student" && password == "123") {

                com.mchzainuri.anmp.model.HabitRepository.activeUser = username

                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            } else {
                binding.tilUsername.error = "Username atau password salah!"
                binding.tilPassword.error = "Username atau password salah!"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}