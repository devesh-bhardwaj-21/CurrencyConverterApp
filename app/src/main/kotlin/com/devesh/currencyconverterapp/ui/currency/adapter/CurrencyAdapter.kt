package com.devesh.currencyconverterapp.ui.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devesh.currencyconverterapp.data.api.model.Rates
import com.devesh.currencyconverterapp.databinding.CurrencyItemBinding

class CurrencyAdapter :
    ListAdapter<Rates, CurrencyAdapter.ViewHolder>(CurrencyConverterDiffCallback()) {

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
        fun bind(item: Rates) {
        }
    }
}

class CurrencyConverterDiffCallback : DiffUtil.ItemCallback<Rates>() {
    override fun areItemsTheSame(oldItem: Rates, newItem: Rates): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Rates, newItem: Rates): Boolean {
        return oldItem == newItem
    }
}
