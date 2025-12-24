package com.example.siakad.ui.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private lateinit var adapter: InfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        loadInfo()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = InfoAdapter()
        binding.rvInfo.apply {
            layoutManager = LinearLayoutManager(this@InfoActivity)
            adapter = this@InfoActivity.adapter
        }
    }

    private fun loadInfo() {
        val infoList = listOf(
            InfoItem(
                "Libur Natal & Tahun Baru",
                "24 Desember 2025",
                "Penting",
                "Kampus akan libur pada tanggal 24-26 Desember 2025 dan 1 Januari 2026. Kuliah akan dimulai kembali pada 2 Januari 2026."
            ),
            InfoItem(
                "Pendaftaran UAS Semester Ganjil",
                "20 Desember 2025",
                "Akademik",
                "Pendaftaran UAS dibuka mulai 20-30 Desember 2025. Mahasiswa wajib melunasi pembayaran sebelum mendaftar."
            ),
            InfoItem(
                "Workshop Pemrograman Mobile",
                "15 Desember 2025",
                "Kegiatan",
                "Akan diadakan workshop pemrograman mobile menggunakan Kotlin dan Flutter pada tanggal 15 Januari 2026. Pendaftaran gratis untuk mahasiswa."
            )
        )

        adapter.submitList(infoList)
        binding.tvEmpty.visibility = if (infoList.isEmpty()) View.VISIBLE else View.GONE
    }
}
