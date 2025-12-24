package com.example.siakad.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment // Tambahkan import ini
import androidx.navigation.ui.setupWithNavController
import com.example.siakad.R
import com.example.siakad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CARA PERBAIKAN: Ambil NavHostFragment terlebih dahulu
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Ambil NavController dari navHostFragment
        val navController = navHostFragment.navController

        // Hubungkan Bottom Navigation dengan NavController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}
