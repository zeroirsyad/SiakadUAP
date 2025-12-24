package com.example.siakad.ui.jadwal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemJadwalBinding

data class ScheduleItem(
    val startTime: String,
    val endTime: String,
    val courseName: String,
    val courseCode: String,
    val lecturer: String,
    val room: String
)

class ScheduleAdapter : ListAdapter<ScheduleItem, ScheduleAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemJadwalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemJadwalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ScheduleItem) {
            binding.apply {
                tvStartTime.text = item.startTime
                tvEndTime.text = item.endTime
                tvCourseName.text = item.courseName
                tvCourseCode.text = item.courseCode
                tvLecturer.text = item.lecturer
                tvRoom.text = item.room
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ScheduleItem>() {
        override fun areItemsTheSame(oldItem: ScheduleItem, newItem: ScheduleItem) =
            oldItem.courseCode == newItem.courseCode

        override fun areContentsTheSame(oldItem: ScheduleItem, newItem: ScheduleItem) =
            oldItem == newItem
    }
}