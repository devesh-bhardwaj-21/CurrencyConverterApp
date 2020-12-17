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
import timber.log.Timber
import java.util.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CurrencyFragment : Fragment(R.layout.currency_fragment) {

    private val viewModel: CurrencyViewModel by viewModels()
    private val binding: CurrencyFragmentBinding by viewBinding()
    private val adapter: CurrencyAdapter = CurrencyAdapter()
    private val uiCurrencyModelList = mutableListOf<UiCurrencyModel>()

    fun onBaseValueChanged(uiCurrencyModel: UiCurrencyModel, adapterPosition: Int) {
        viewModel.onBaseValueChanged(uiCurrencyModel.currencyCode)
        if (uiCurrencyModel.currencyCode.equals(uiCurrencyModelList.first().currencyCode) && adapterPosition == 0) {
            return
        }
        // shift selected currency to top of list. All other shift by one down
        Collections.swap(uiCurrencyModelList, adapterPosition, 0)
        adapter.notifyItemMoved(adapterPosition, 0)

        viewModel.onBaseCurrencyValueChanged(uiCurrencyModel, uiCurrencyModelList, adapterPosition)
        adapter.notifyDataSetChanged()

        // make sure user is on top of the list
        binding.recyclerView.scrollToPosition(0)
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
                        uiCurrencyModelList.clear()
                        uiCurrencyModelList.addAll(uiState.data)
                        adapter.submitList(uiCurrencyModelList)
                    }
                    is CurrencyViewModel.UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Timber.e("Api failure occurred!")
                        showNoDataError(view, "\uD83D\uDE28 Wooops! Seems like something is wrong!")
                    }
                    is CurrencyViewModel.UiState.InProgress -> {
                    }
                }
            }
        )
    }
}
