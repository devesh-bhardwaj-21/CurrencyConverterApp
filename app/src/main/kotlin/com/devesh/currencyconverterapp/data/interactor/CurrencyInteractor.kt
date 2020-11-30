package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.data.repository.CurrencyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyInteractor @Inject constructor(private val repository: CurrencyRepository) {

    fun getCurrencyStateFlow(): StateFlow<CurrencyModel> {
        return repository.getCurrencyStateFlow()
    }

    fun onBaseValueChanged(value: String) {
        repository.onBaseValueChanged(value)
    }

    fun onBaseCurrencyValueChanged(value: String) {
    }
}
