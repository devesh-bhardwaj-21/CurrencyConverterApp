package com.devesh.currencyconverterapp.ui.currency.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devesh.currencyconverterapp.databinding.CurrencyItemBinding
import com.devesh.currencyconverterapp.ui.currency.CurrencyViewModel
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.math.BigDecimal
import java.text.NumberFormat
import java.text.ParseException
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyAdapter @Inject constructor(
    val viewModel: CurrencyViewModel
) :
    ListAdapter<UiCurrencyModel, CurrencyAdapter.ViewHolder>(CurrencyConverterDiffCallback()) {

    var newBaseCurrencyValue: BigDecimal? = BigDecimal.ZERO
    var numberFormat = NumberFormat.getInstance()
    private var baseCurrency = ""

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

    override fun submitList(list: List<UiCurrencyModel>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    inner class ViewHolder constructor(private val binding: CurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var baseCurrencyEditText: EditText? = null

        fun bind(model: UiCurrencyModel) {
            binding.currencyCount.setText(model.currencyValue.toString())
            binding.currencyCode.text = model.currencyCode
            binding.currencyName.text = itemView.context.getString(model.currencyNameId)
            binding.currencyFlag.setImageDrawable(
                ResourcesCompat.getDrawable(
                    itemView.resources,
                    model.currencyFlagId,
                    itemView.context.theme
                )
            )

            if (layoutPosition == 0) {
                binding.currencyCount.addTextChangedListener(textWatcher)
                baseCurrencyEditText = binding.currencyCount
            }

            binding.currencyCount.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    val currencyEditText = binding.currencyCount
                    baseCurrency = model.currencyCode
                    if (layoutPosition > 0) {
                             viewModel.getCurrencyStateFlow(
                                 baseCurrency,
                                 true
                             )
                    }
                    if (baseCurrencyEditText != currencyEditText) {
                        baseCurrencyEditText?.removeTextChangedListener(textWatcher)
                        currencyEditText.addTextChangedListener(textWatcher)
                    }
                }
            }
        }

        private val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text.isNullOrEmpty()) {
                    return
                }
                try {
                    newBaseCurrencyValue = numberFormat.parse(text.toString())?.toDouble()
                        ?.toBigDecimal()
                      viewModel.onBaseCurrencyValueChanged(
                          newBaseCurrencyValue,
                          baseCurrency
                      )
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }
    }
}

class CurrencyConverterDiffCallback : DiffUtil.ItemCallback<UiCurrencyModel>() {
    override fun areItemsTheSame(oldItem: UiCurrencyModel, newItem: UiCurrencyModel): Boolean {
        return oldItem.currencyCode == newItem.currencyCode
    }

    override fun areContentsTheSame(oldItem: UiCurrencyModel, newItem: UiCurrencyModel): Boolean {
        return oldItem.currencyValue == newItem.currencyValue
    }
}