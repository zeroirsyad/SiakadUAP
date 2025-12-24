package com.example.siakad.ui.info

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemInfoBinding

data class InfoItem(
    val title: String,
    val date: String,
    val category: String,
    val content: String
)

class InfoAdapter : ListAdapter<InfoItem, InfoAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInfoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InfoItem) {
            binding.apply {
                tvTitle.text = item.title
                tvDate.text = item.date
                chipCategory.text = item.category
                tvContent.text = item.content

                btnReadMore.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Membuka detail: ${item.title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<InfoItem>() {
        override fun areItemsTheSame(oldItem: InfoItem, newItem: InfoItem) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: InfoItem, newItem: InfoItem) =
            oldItem == newItem
    }
}