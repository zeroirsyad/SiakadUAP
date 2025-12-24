package com.example.siakad.ui.krs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.ActivityKrsBinding

class KrsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKrsBinding
    private lateinit var adapter: KrsAdapter
    private var totalSks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKrsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadCourses()
        setupButtons()
        updateSksSummary()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = KrsAdapter { isChecked, sks ->
            if (isChecked) {
                totalSks += sks
            } else {
                totalSks -= sks
            }
            updateSksSummary()
        }

        binding.rvCourses.apply {
            layoutManager = LinearLayoutManager(this@KrsActivity)
            adapter = this@KrsActivity.adapter
        }
    }

    private fun loadCourses() {
        val courses = listOf(
            CourseItem("Pemrograman Mobile", "TIF-401", 3, "Dr. John Doe, M.Kom",
                "Senin, 08:00 - 10:00 | Lab Komputer 1", "Wajib", false),
            CourseItem("Basis Data Lanjut", "TIF-402", 3, "Dr. Jane Smith, M.T",
                "Selasa, 10:00 - 12:00 | Ruang 201", "Wajib", false),
            CourseItem("Jaringan Komputer", "TIF-403", 3, "Dr. Ahmad, M.Kom",
                "Rabu, 13:00 - 15:00 | Lab Jaringan", "Wajib", false),
            CourseItem("Keamanan Informasi", "TIF-404", 3, "Dr. Budi, M.Kom",
                "Kamis, 08:00 - 10:00 | Ruang 301", "Pilihan", false),
            CourseItem("Manajemen Proyek", "TIF-405", 2, "Dr. Siti, M.M",
                "Jumat, 10:00 - 11:40 | Ruang 202", "Pilihan", false)
        )

        adapter.submitList(courses)
    }

    private fun updateSksSummary() {
        binding.tvSksTaken.text = totalSks.toString()
        binding.tvSksMax.text = "24"
    }

    private fun setupButtons() {
        binding.btnSave.setOnClickListener {
            Toast.makeText(this, "KRS berhasil disimpan!", Toast.LENGTH_SHORT).show()
        }

        binding.btnPrint.setOnClickListener {
            Toast.makeText(this, "Mencetak KRS...", Toast.LENGTH_SHORT).show()
        }
    }
}