package com.example.siakad.ui.jadwal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siakad.R
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.siakad.databinding.ActivityJadwalBinding
import com.google.android.material.tabs.TabLayoutMediator

class JadwalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJadwalBinding

    private val days = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJadwalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupViewPager() {
        val adapter = SchedulePagerAdapter(this)
        binding.viewpagerSchedule.adapter = adapter

        TabLayoutMediator(binding.tabDays, binding.viewpagerSchedule) { tab, position ->
            tab.text = days[position]
        }.attach()
    }

    inner class SchedulePagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = days.size
        override fun createFragment(position: Int): Fragment =
            DayScheduleFragment.newInstance(days[position])
    }
}
