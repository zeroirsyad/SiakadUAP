package com.example.siakad.ui.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.siakad.databinding.FragmentDashboardBinding
import com.example.siakad.utils.SessionManager
import android.content.Intent
import com.example.siakad.ui.krs.KrsActivity
import com.example.siakad.ui.khs.KhsActivity
import com.example.siakad.ui.info.InfoActivity
import com.example.siakad.ui.absensi.AbsensiActivity
import com.example.siakad.ui.pembayaran.PembayaranActivity
import com.example.siakad.ui.jadwal.JadwalActivity


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
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
            }

            cardKhs.setOnClickListener {
                showToast("Fitur KHS")
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
            }

            cardAbsensi.setOnClickListener {
                showToast("Fitur Absensi")
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
            }

            cardPayment.setOnClickListener {
                showToast("Fitur Pembayaran")
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
            }

            cardInfo.setOnClickListener {
                showToast("Fitur Info Akademik")
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
            }

            cardSchedule.setOnClickListener {
                showToast("Fitur Jadwal")
                val intent=Intent(requireContext(),KrsActivity::class.java)
                startActivity(intent)
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
