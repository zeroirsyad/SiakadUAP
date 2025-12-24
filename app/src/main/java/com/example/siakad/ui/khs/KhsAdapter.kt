package com.example.siakad.ui.khs

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemKhsBinding

data class GradeItem(
    val courseName: String,
    val courseCode: String,
    val sks: Int,
    val score: Double,
    val grade: String,
    val weight: Double
)

class KhsAdapter : ListAdapter<GradeItem, KhsAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKhsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemKhsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GradeItem) {
            binding.apply {
                tvCourseName.text = item.courseName
                tvCourseCode.text = item.courseCode
                tvSks.text = item.sks.toString()
                tvScore.text = item.score.toString()
                tvGrade.text = item.grade
                tvWeight.text = item.weight.toString()

                // Set grade color
                val gradeColor = when (item.grade) {
                    "A", "A-" -> Color.parseColor("#4CAF50")
                    "B+", "B" -> Color.parseColor("#2196F3")
                    "B-", "C+" -> Color.parseColor("#FF9800")
                    else -> Color.parseColor("#F44336")
                }
                tvGrade.setTextColor(gradeColor)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<GradeItem>() {
        override fun areItemsTheSame(oldItem: GradeItem, newItem: GradeItem) =
            oldItem.courseCode == newItem.courseCode

        override fun areContentsTheSame(oldItem: GradeItem, newItem: GradeItem) =
            oldItem == newItem
    }
}
