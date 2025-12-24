package com.example.siakad.ui.login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.siakad.databinding.ActivityLoginBinding
import com.example.siakad.ui.main.MainActivity
import com.example.siakad.utils.SessionManager
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val npm = binding.etNpm.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (npm.isEmpty()) {
            binding.etNpm.error = "NPM tidak boleh kosong"
            return
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Password tidak boleh kosong"
            return
        }

        // Simulasi login (ganti dengan API call)
        lifecycleScope.launch {
            try {
                // TODO: Implementasi Retrofit API call
                // val response = apiService.login(npm, password)

                // Simulasi sukses login
                sessionManager.saveLoginSession(
                    npm = npm,
                    name = "John Doe",
                    prodi = "Teknik Informatika",
                    semester = 5,
                    token = "dummy_token_123"
                )

                Toast.makeText(this@LoginActivity, "Login berhasil!", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            } catch (e: Exception) {
                Toast.makeText(this@LoginActivity, "Login gagal: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}