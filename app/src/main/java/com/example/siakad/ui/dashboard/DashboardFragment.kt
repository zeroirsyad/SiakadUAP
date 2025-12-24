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
import com.example.siakad.ui.absensi.AbsensiActivity
import com.example.siakad.ui.khs.KhsActivity
import com.example.siakad.ui.krs.KrsActivity
import com.example.siakad.ui.pembayaran.PembayaranActivity
import com.example.siakad.ui.info.InfoActivity
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
                val intent = Intent(requireContext(), KrsActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur KRS") // Anda bisa hapus atau biarkan untuk debugging
            }

            cardKhs.setOnClickListener {
                val intent = Intent(requireContext(), KhsActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur KHS")
            }

            cardAbsensi.setOnClickListener {
                val intent = Intent(requireContext(), AbsensiActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur Absensi")
            }

            cardPayment.setOnClickListener {
                val intent = Intent(requireContext(), PembayaranActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur Pembayaran")
            }

            cardInfo.setOnClickListener {
                val intent = Intent(requireContext(), InfoActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur Info Akademik")
            }

            cardSchedule.setOnClickListener {
                val intent = Intent(requireContext(), JadwalActivity::class.java)
                startActivity(intent) // TAMBAHKAN INI
                // showToast("Fitur Jadwal")
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
