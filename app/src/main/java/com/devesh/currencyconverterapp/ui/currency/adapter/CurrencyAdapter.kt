package com.devesh.currencyconverterapp.ui.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devesh.currencyconverterapp.data.api.model.Rate
import com.devesh.currencyconverterapp.databinding.CurrencyItemBinding

class CurrencyAdapter :
    ListAdapter<Rate, CurrencyAdapter.ViewHolder>(CurrencyConverterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CurrencyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder constructor(binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Rate) {
        }
    }
}

class CurrencyConverterDiffCallback : DiffUtil.ItemCallback<Rate>() {
    override fun areItemsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem.key == newItem.key &&
            oldItem.name == newItem.name &&
            oldItem.value == newItem.value &&
            oldItem.position == newItem.position
    }

    override fun areContentsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem == newItem
    }
}
