package com.example.siakad.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.siakad.databinding.FragmentProfileBinding
import com.example.siakad.ui.login.LoginActivity
import com.example.siakad.utils.SessionManager

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionManager = SessionManager(requireContext())

        setupProfileData()
        setupLogoutButton()
    }

    private fun setupProfileData() {
        binding.apply {
            tvName.text = sessionManager.getName()
            tvNpm.text = sessionManager.getNpm()
            tvProdi.text = sessionManager.getProdi()
            tvSemester.text = "Semester ${sessionManager.getSemester()}"

            // Data tambahan (contoh)
            tvEmail.text = "${sessionManager.getNpm()}@student.uap.ac.id"
            tvPhone.text = "+62 812-3456-7890"
            tvAddress.text = "Jl. A. Yani No. 1A, Tambahrejo, Gadingrejo, Pringsewu"
            tvParentName.text = "Bapak/Ibu Wali"
            tvParentPhone.text = "+62 813-9876-5432"
        }
    }

    private fun setupLogoutButton() {
        binding.btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
            .setPositiveButton("Ya") { _, _ ->
                performLogout()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }

    private fun performLogout() {
        sessionManager.logout()

        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
