package com.example.siakad.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadNotifications()
    }

    private fun setupRecyclerView() {
        adapter = NotificationAdapter()
        binding.rvNotifications.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotifications.adapter = adapter
    }

    private fun loadNotifications() {
        val notifications = listOf(
            NotificationItem("Nilai Keluar", "Nilai UTS telah tersedia", "2 jam lalu", "academic"),
            NotificationItem("Pengumuman", "Jadwal kuliah berubah", "1 hari lalu", "info"),
            NotificationItem("Pembayaran", "Batas UKT: 31 Des 2025", "3 hari lalu", "payment"),
            NotificationItem("Jadwal Ujian", "Jadwal UAS dipublikasikan", "1 minggu lalu", "schedule")
        )

        // PERBAIKAN: Masukkan list 'notifications' ke dalam submitList
        adapter.submitList(notifications)

        binding.tvEmpty.visibility = if (notifications.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// Biarkan data class ini di sini ATAU pindahkan ke file tersendiri (NotificationItem.kt)

