package com.example.siakad.ui.jadwal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.FragmentDayScheduleBinding

class DayScheduleFragment : Fragment() {
    private var _binding: FragmentDayScheduleBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ScheduleAdapter // Deklarasi adapter sudah benar
    private var dayName: String = ""

    companion object {
        private const val ARG_DAY = "day"

        fun newInstance(day: String) = DayScheduleFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_DAY, day)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dayName = arguments?.getString(ARG_DAY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadSchedules()
    }

    private fun setupRecyclerView() {
        adapter = ScheduleAdapter()
        // --- PERBAIKAN DI SINI ---
        // Tetapkan layoutManager dan adapter ke RecyclerView melalui binding
        binding.rvSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSchedule.adapter = this.adapter
    }

    private fun loadSchedules() {
        // Dummy data
        val schedules = when (dayName) {
            "Senin" -> listOf(
                ScheduleItem("08:00", "10:00", "Pemrograman Mobile", "TIF-401",
                    "Dr. John Doe, M.Kom", "Lab Komputer 1"),
                ScheduleItem("10:00", "12:00", "Basis Data", "TIF-301",
                    "Dr. Jane Smith, M.T", "Ruang 201")
            )
            "Selasa" -> listOf(
                ScheduleItem("13:00", "15:00", "Jaringan Komputer", "TIF-402",
                    "Dr. Ahmad, M.Kom", "Lab Jaringan")
            )
            else -> emptyList()
        }

        adapter.submitList(schedules)
        // --- PERBAIKAN DI SINI ---
        // Akses tvEmpty melalui binding
        binding.tvEmpty.visibility = if (schedules.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
