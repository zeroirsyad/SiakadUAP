

package com.example.siakad.ui.krs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemKrsBinding

data class CourseItem(
    val courseName: String,
    val courseCode: String,
    val sks: Int,
    val lecturer: String,
    val schedule: String,
    val status: String,
    var isSelected: Boolean = false
)

class KrsAdapter(
    private val onCheckChanged: (Boolean, Int) -> Unit
) : ListAdapter<CourseItem, KrsAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKrsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onCheckChanged)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemKrsBinding,
        private val onCheckChanged: (Boolean, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CourseItem) {
            binding.apply {
                tvCourseName.text = item.courseName
                tvCourseCode.text = "${item.courseCode} | ${item.sks} SKS"
                tvLecturer.text = item.lecturer
                tvSchedule.text = item.schedule
                chipStatus.text = item.status
                checkbox.isChecked = item.isSelected

                checkbox.setOnCheckedChangeListener { _, isChecked ->
                    item.isSelected = isChecked
                    onCheckChanged(isChecked, item.sks)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CourseItem>() {
        override fun areItemsTheSame(oldItem: CourseItem, newItem: CourseItem) =
            oldItem.courseCode == newItem.courseCode

        override fun areContentsTheSame(oldItem: CourseItem, newItem: CourseItem) =
            oldItem == newItem
    }
}
