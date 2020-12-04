package com.devesh.currencyconverterapp.ui.currency

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.databinding.CurrencyFragmentBinding
import com.devesh.currencyconverterapp.ui.currency.adapter.CurrencyAdapter
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import com.devesh.currencyconverterapp.utils.showNoDataError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.currency_fragment) {

    private val viewModel: CurrencyViewModel by viewModels()
    private val binding: CurrencyFragmentBinding by viewBinding()
    private val adapter: CurrencyAdapter = CurrencyAdapter()

    fun onBaseValueChanged(uiCurrencyModel: UiCurrencyModel) {
        viewModel.onBaseValueChanged(uiCurrencyModel.currencyCode)
    }

    fun onBaseCurrencyValueChanged(uiCurrencyModel: UiCurrencyModel) {
        viewModel.onBaseCurrencyValueChanged(uiCurrencyModel.currencyCode, uiCurrencyModel.currencyValue)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpUI()
        setUpObservers()
    }

    private fun setUpUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setUpObservers() {
        viewModel.uiStateLiveData.observe(
            viewLifecycleOwner,
            { uiState ->
                when (uiState) {
                    is CurrencyViewModel.UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.submitList(uiState.data)
                    }
                    is CurrencyViewModel.UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        showNoDataError(view, "\uD83D\uDE28 Wooops! Seems like something is wrong!")
                    }
                    is CurrencyViewModel.UiState.InProgress -> {
                    }
                }
            }
        )
    }
}
