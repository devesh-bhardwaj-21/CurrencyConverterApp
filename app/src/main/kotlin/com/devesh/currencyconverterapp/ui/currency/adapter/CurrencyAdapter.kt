package com.devesh.currencyconverterapp.ui.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devesh.currencyconverterapp.databinding.CurrencyItemBinding

class CurrencyAdapter :
    ListAdapter<Rateeee, CurrencyAdapter.ViewHolder>(CurrencyConverterDiffCallback()) {

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
        fun bind(item: Rateeee) {
        }
    }
}

class CurrencyConverterDiffCallback : DiffUtil.ItemCallback<Rateeee>() {
    override fun areItemsTheSame(oldItem: Rateeee, newItem: Rateeee): Boolean {
        return oldItem.key == newItem.key &&
            oldItem.name == newItem.name &&
            oldItem.value == newItem.value &&
            oldItem.position == newItem.position
    }

    override fun areContentsTheSame(oldItem: Rateeee, newItem: Rateeee): Boolean {
        return oldItem == newItem
    }
}
