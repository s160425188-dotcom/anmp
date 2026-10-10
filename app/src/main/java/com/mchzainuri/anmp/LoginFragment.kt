package com.mchzainuri.anmp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

            // Reset pesan error setiap kali tombol ditekan
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            // Validasi login hardcode sesuai ketentuan
            if (username == "student" && password == "123") {
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            } else {
                // Menampilkan teks error warna merah di bawah input box
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