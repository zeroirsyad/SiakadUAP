package com.example.siakad.ui.absensi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.ActivityAbsensiBinding

class AbsensiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbsensiBinding
    private lateinit var adapter: AbsensiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbsensiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupSpinner()
        setupRecyclerView()
        loadAttendanceSummary()
        loadAttendanceList()
        setupFab()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupSpinner() {
        val courses = listOf(
            "Semua Mata Kuliah",
            "Pemrograman Mobile",
            "Basis Data Lanjut",
            "Jaringan Komputer",
            "Keamanan Informasi"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, courses)
        binding.spinnerCourse.setAdapter(adapter)
    }

    private fun setupRecyclerView() {
        adapter = AbsensiAdapter()
        binding.rvAttendance.apply {
            layoutManager = LinearLayoutManager(this@AbsensiActivity)
            adapter = this@AbsensiActivity.adapter
        }
    }

    private fun loadAttendanceSummary() {
        binding.apply {
            tvPresent.text = "85"
            tvExcused.text = "3"
            tvSick.text = "2"
            tvAbsent.text = "10"
            tvPercentage.text = "85%"
        }
    }

    private fun loadAttendanceList() {
        val attendanceList = listOf(
            AttendanceItem(
                "Pemrograman Mobile",
                "Senin, 20 Desember 2025 | 08:00 - 10:00",
                "Dr. John Doe, M.Kom",
                "Lab Komputer 1",
                "Hadir",
                null
            ),
            AttendanceItem(
                "Basis Data Lanjut",
                "Selasa, 19 Desember 2025 | 10:00 - 12:00",
                "Dr. Jane Smith, M.T",
                "Ruang 201",
                "Hadir",
                null
            ),
            AttendanceItem(
                "Jaringan Komputer",
                "Rabu, 18 Desember 2025 | 13:00 - 15:00",
                "Dr. Ahmad, M.Kom",
                "Lab Jaringan",
                "Izin",
                "Mengikuti lomba"
            ),
            AttendanceItem(
                "Keamanan Informasi",
                "Kamis, 17 Desember 2025 | 08:00 - 10:00",
                "Dr. Budi, M.Kom",
                "Ruang 301",
                "Sakit",
                "Sakit demam"
            ),
            AttendanceItem(
                "Manajemen Proyek",
                "Jumat, 16 Desember 2025 | 10:00 - 11:40",
                "Dr. Siti, M.M",
                "Ruang 202",
                "Alpa",
                null
            )
        )

        adapter.submitList(attendanceList)
    }

    private fun setupFab() {
        binding.fabScanQr.setOnClickListener {
            Toast.makeText(this, "Membuka scanner QR...", Toast.LENGTH_SHORT).show()
            // TODO: Implementasi QR Code scanner
        }
    }
}
