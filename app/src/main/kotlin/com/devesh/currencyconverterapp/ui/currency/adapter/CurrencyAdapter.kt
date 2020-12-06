package com.devesh.currencyconverterapp.ui.currency.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devesh.currencyconverterapp.databinding.CurrencyItemBinding
import com.devesh.currencyconverterapp.ui.currency.CurrencyFragment
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.text.NumberFormat
import java.text.ParseException
import java.util.*

fun Number.roundTo(
    numFractionDigits: Int
) = "%.${numFractionDigits}f".format(this, Locale.ENGLISH).toDouble()

@ExperimentalCoroutinesApi
class CurrencyAdapter :
    ListAdapter<UiCurrencyModel, CurrencyAdapter.ViewHolder>(CurrencyConverterDiffCallback()) {

    var newBaseCurrencyValue: Double? = 0.0
    var numberFormat = NumberFormat.getInstance()
    private var baseCountView: EditText? = null

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

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (!s.isNullOrEmpty()) {
                try {
                    newBaseCurrencyValue = numberFormat.parse(s.toString())?.toDouble()
                    // update all items except the first one
                    notifyItemRangeChanged(1, itemCount - 1)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }
    }

    inner class ViewHolder constructor(val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UiCurrencyModel) {
            model.currencyValue = if (adapterPosition == 0) newBaseCurrencyValue else newBaseCurrencyValue?.let {
                model.multiplier.times(
                    it
                )
            }
            model.currencyValue = model.currencyValue?.roundTo(2)
            binding.currencyCode.text = model.currencyCode
            binding.currencyName.text = itemView.context.getString(model.currencyNameId)
            binding.currencyFlag.setImageDrawable(
                ResourcesCompat.getDrawable(
                    itemView.resources,
                    model.currencyFlagId,
                    itemView.context.theme
                )
            )

            binding.currencyCount.post { binding.currencyCount.setText(numberFormat.format(model.currencyValue)) }
            if (adapterPosition == 0) {
                binding.currencyCount.addTextChangedListener(textWatcher)
                baseCountView = binding.currencyCount
            }

            val clickListener = View.OnClickListener { v ->
                val tag = v?.tag

                // request focus for item that is selected as base
                val selectedBaseView = binding.currencyCount
                selectedBaseView.requestFocus()
                selectedBaseView.setSelection(selectedBaseView.length())

                if (tag is UiCurrencyModel) {
                    CurrencyFragment().onBaseValueChanged(tag, adapterPosition)
                    newBaseCurrencyValue = tag.currencyValue

                    if (baseCountView != selectedBaseView) {
                        // update text watchers
                        baseCountView?.removeTextChangedListener(textWatcher)
                        selectedBaseView.addTextChangedListener(textWatcher)
                    }
                }
            }
            binding.currencyLayout.setOnClickListener(clickListener)
            binding.currencyCount.setOnClickListener(clickListener)
        }
    }
}

class CurrencyConverterDiffCallback : DiffUtil.ItemCallback<UiCurrencyModel>() {
    override fun areItemsTheSame(oldItem: UiCurrencyModel, newItem: UiCurrencyModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UiCurrencyModel, newItem: UiCurrencyModel): Boolean {
        return oldItem.currencyValue == newItem.currencyValue
    }
}