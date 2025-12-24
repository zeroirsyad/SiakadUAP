package com.example.siakad.ui.khs

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.R
import com.example.siakad.databinding.ActivityKhsBinding

class KhsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKhsBinding
    private lateinit var adapter: KhsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKhsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupSpinner()
        setupRecyclerView()
        loadGrades()
        setupButtons()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupSpinner() {
        val semesters = listOf(
            "Semester 5 - Ganjil 2024/2025",
            "Semester 4 - Genap 2023/2024",
            "Semester 3 - Ganjil 2023/2024",
            "Semester 2 - Genap 2022/2023",
            "Semester 1 - Ganjil 2022/2023"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, semesters)
        binding.spinnerSemester.setAdapter(adapter)
    }

    private fun setupRecyclerView() {
        adapter = KhsAdapter()
        binding.rvGrades.apply {
            layoutManager = LinearLayoutManager(this@KhsActivity)
            adapter = this@KhsActivity.adapter
        }
    }

    private fun loadGrades() {
        val grades = listOf(
            GradeItem("Pemrograman Mobile", "TIF-401", 3, 87.5, "A", 4.0),
            GradeItem("Basis Data Lanjut", "TIF-402", 3, 82.0, "A-", 3.7),
            GradeItem("Jaringan Komputer", "TIF-403", 3, 78.5, "B+", 3.3),
            GradeItem("Keamanan Informasi", "TIF-404", 3, 85.0, "A", 4.0),
            GradeItem("Manajemen Proyek", "TIF-405", 2, 80.0, "B+", 3.3),
            GradeItem("Kewirausahaan", "TIF-406", 2, 88.0, "A", 4.0)
        )

        adapter.submitList(grades)

        // Update summary
        binding.tvIps.text = "3.75"
        binding.tvIpk.text = "3.68"
        binding.tvTotalSks.text = "96"
    }

    private fun setupButtons() {
        binding.btnPrint.setOnClickListener {
            Toast.makeText(this, "Mencetak KHS...", Toast.LENGTH_SHORT).show()
        }
    }
}

