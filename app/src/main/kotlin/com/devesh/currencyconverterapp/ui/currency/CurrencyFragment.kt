package com.devesh.currencyconverterapp.ui.currency

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber
import java.math.BigDecimal

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.currency_fragment) {

    private val viewModel: CurrencyViewModel by viewModels()
    private val binding: CurrencyFragmentBinding by viewBinding()
    private val adapter: CurrencyAdapter = CurrencyAdapter(this)
    private val uiCurrencyModelList = mutableListOf<UiCurrencyModel>()

    fun onBaseCurrencyChanged(
        uiCurrencyModel: UiCurrencyModel,
        layoutPosition: Int
    ) {
        if (uiCurrencyModel.currencyCode.equals(uiCurrencyModelList.first().currencyCode) && layoutPosition == 0) {
            return
        }
        viewModel.getCurrencyStateFlow(uiCurrencyModel.currencyCode, true)
        binding.recyclerView.scrollToPosition(0)
    }

    fun onBaseCurrencyValueChanged(
        newBaseCurrencyValue: BigDecimal?,
        baseCurrency: String
    ) {
        viewModel.onBaseCurrencyValueChanged(newBaseCurrencyValue, baseCurrency)
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
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun setUpObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiStateFlow.collectLatest { uiState ->
                when (uiState) {
                    is CurrencyViewModel.UiState.Success -> {
                        Timber.d("Api response successful")
                        binding.progressBar.visibility = View.GONE
                        uiCurrencyModelList.clear()
                        uiCurrencyModelList.addAll(uiState.data)
                        adapter.submitList(uiState.data)
                    }
                    is CurrencyViewModel.UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Timber.e("Api failure occurred!")
                        showNoDataError(view, "\uD83D\uDE28 Wooops! Seems like something is wrong!")
                    }
                    is CurrencyViewModel.UiState.InProgress -> {
                        Timber.d("Api is in Progress")
                    }
                }
            }
        }
    }
}
