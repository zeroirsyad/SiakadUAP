package com.example.siakad.ui.pembayaran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siakad.databinding.ItemPaymentHistoryBinding

data class PaymentHistoryItem(
    val semester: String,
    val date: String,
    val amount: String
)

class PaymentHistoryAdapter :
    ListAdapter<PaymentHistoryItem, PaymentHistoryAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPaymentHistoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemPaymentHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PaymentHistoryItem) {
            binding.apply {
                tvSemester.text = item.semester
                tvDate.text = item.date
                tvAmount.text = item.amount
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PaymentHistoryItem>() {
        override fun areItemsTheSame(
            oldItem: PaymentHistoryItem,
            newItem: PaymentHistoryItem
        ) = oldItem.semester == newItem.semester

        override fun areContentsTheSame(
            oldItem: PaymentHistoryItem,
            newItem: PaymentHistoryItem
        ) = oldItem == newItem
    }
}
