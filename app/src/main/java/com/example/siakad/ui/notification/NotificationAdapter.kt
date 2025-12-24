package com.example.siakad.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.R
import com.example.siakad.databinding.ItemNotificationBinding

// Gunakan NotificationItem (tanpa prefix NotificationAdapter)
class NotificationAdapter : ListAdapter<NotificationItem, NotificationAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNotificationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NotificationItem) {
            binding.apply {
                tvTitle.text = item.title
                tvMessage.text = item.message
                tvTime.text = item.time

                val iconRes = when (item.type) {
                    "academic" -> R.drawable.ic_academic
                    "info" -> R.drawable.ic_info
                    "payment" -> R.drawable.ic_payment
                    "schedule" -> R.drawable.ic_schedule
                    else -> R.drawable.ic_notification
                }
                ivIcon.setImageResource(iconRes)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NotificationItem>() {
        override fun areItemsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
            return oldItem.title == newItem.title && oldItem.time == newItem.time
        }

        override fun areContentsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
            return oldItem == newItem
        }
    }
}
