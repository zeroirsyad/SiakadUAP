package com.example.siakad.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.siakad.databinding.FragmentDashboardBinding
import com.example.siakad.utils.SessionManager

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionManager = SessionManager(requireContext())

        setupProfile()
        setupMenuClicks()
    }

    private fun setupProfile() {
        binding.apply {
            tvName.text = sessionManager.getName()
            tvNpm.text = "NPM: ${sessionManager.getNpm()}"
            tvProdi.text = sessionManager.getProdi()
            tvSemester.text = "Semester: ${sessionManager.getSemester()}"
        }
    }

    private fun setupMenuClicks() {
        binding.apply {
            cardKrs.setOnClickListener {
                showToast("Fitur KRS")
            }

            cardKhs.setOnClickListener {
                showToast("Fitur KHS")
            }

            cardAbsensi.setOnClickListener {
                showToast("Fitur Absensi")
            }

            cardPayment.setOnClickListener {
                showToast("Fitur Pembayaran")
            }

            cardInfo.setOnClickListener {
                showToast("Fitur Info Akademik")
            }

            cardSchedule.setOnClickListener {
                showToast("Fitur Jadwal")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
