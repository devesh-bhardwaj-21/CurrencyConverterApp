package com.devesh.currencyconverterapp.data.repository

import com.devesh.currencyconverterapp.data.api.ApiService
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.utils.baseCurrencyValueList
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyRepository @Inject constructor(private val apiService: ApiService) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var currentBaseValue = baseCurrencyValueList.first()

    private val currencyStateFlow = MutableStateFlow<CurrencyModel?>(null)

    init {
        coroutineScope.launch { refreshCurrencyStateFlow() }
    }

    fun getCurrencyStateFlow(base: String): StateFlow<CurrencyModel?> {
        currentBaseValue = base
        return currencyStateFlow
    }

    private suspend fun refreshCurrencyStateFlow() {
        while (true) {
            currencyStateFlow.value = apiService.getCurrencyStateFlow(currentBaseValue)
            delay(REFRESH_DELAY)
        }
    }

    private companion object {
        const val REFRESH_DELAY = 1000L
    }
}
