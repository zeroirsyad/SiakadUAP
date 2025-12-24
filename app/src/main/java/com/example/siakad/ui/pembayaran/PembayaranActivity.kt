package com.example.siakad.ui.pembayaran

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siakad.databinding.ActivityPembayaranBinding
import com.example.siakad.utils.SessionManager

class PembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembayaranBinding
    private lateinit var adapter: PaymentHistoryAdapter
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        setupRecyclerView()
        loadPaymentData()
        setupButtons()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        adapter = PaymentHistoryAdapter()
        binding.rvPaymentHistory.apply {
            layoutManager = LinearLayoutManager(this@PembayaranActivity)
            adapter = this@PembayaranActivity.adapter
        }
    }

    private fun loadPaymentData() {
        // Load data mahasiswa
        binding.apply {
            tvStudentName.text = sessionManager.getName()
            tvNpm.text = sessionManager.getNpm()
            tvUktCategory.text = "Golongan 3"
            tvAmount.text = "Rp 3.500.000"
            tvPaymentDate.text = "20 Desember 2025"
            tvPaymentMethod.text = "Transfer Bank BNI"
            tvPaymentStatus.text = "LUNAS"
        }

        // Load payment history
        val history = listOf(
            PaymentHistoryItem("Semester Ganjil 2024/2025", "20 Desember 2025", "Rp 3.500.000"),
            PaymentHistoryItem("Semester Genap 2023/2024", "15 Juli 2024", "Rp 3.500.000"),
            PaymentHistoryItem("Semester Ganjil 2023/2024", "18 Januari 2024", "Rp 3.500.000"),
            PaymentHistoryItem("Semester Genap 2022/2023", "12 Juli 2023", "Rp 3.500.000")
        )

        adapter.submitList(history)
    }

    private fun setupButtons() {
        binding.btnPrintReceipt.setOnClickListener {
            Toast.makeText(this, "Mencetak bukti pembayaran...", Toast.LENGTH_SHORT).show()
        }
    }
}