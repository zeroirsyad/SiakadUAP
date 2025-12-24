package com.example.siakad.ui.absensi

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemAbsensiBinding

data class AttendanceItem(
    val courseName: String,
    val dateTime: String,
    val lecturer: String,
    val room: String,
    val status: String,
    val note: String?
)

class AbsensiAdapter : ListAdapter<AttendanceItem, AbsensiAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAbsensiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemAbsensiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AttendanceItem) {
            binding.apply {
                tvCourseName.text = item.courseName
                tvDateTime.text = item.dateTime
                tvLecturer.text = item.lecturer
                tvRoom.text = item.room
                chipStatus.text = item.status

                // Set chip color based on status
                val (backgroundColor, textColor) = when (item.status) {
                    "Hadir" -> Pair(Color.parseColor("#4CAF50"), Color.WHITE)
                    "Izin" -> Pair(Color.parseColor("#FF9800"), Color.WHITE)
                    "Sakit" -> Pair(Color.parseColor("#2196F3"), Color.WHITE)
                    "Alpa" -> Pair(Color.parseColor("#F44336"), Color.WHITE)
                    else -> Pair(Color.GRAY, Color.WHITE)
                }

                chipStatus.chipBackgroundColor =
                    android.content.res.ColorStateList.valueOf(backgroundColor)
                chipStatus.setTextColor(textColor)

                // Show note if exists
                if (item.note != null) {
                    tvNote.text = "Keterangan: ${item.note}"
                    tvNote.visibility = View.VISIBLE
                } else {
                    tvNote.visibility = View.GONE
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<AttendanceItem>() {
        override fun areItemsTheSame(oldItem: AttendanceItem, newItem: AttendanceItem) =
            oldItem.courseName == newItem.courseName && oldItem.dateTime == newItem.dateTime

        override fun areContentsTheSame(oldItem: AttendanceItem, newItem: AttendanceItem) =
            oldItem == newItem
    }
}