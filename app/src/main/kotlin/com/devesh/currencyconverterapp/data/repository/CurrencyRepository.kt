package com.devesh.currencyconverterapp.data.repository

import com.devesh.currencyconverterapp.data.api.ApiService
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.utils.baseCurrencyValueList
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyRepository @Inject constructor(private val apiService: ApiService) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var currentBaseValue: String = ""

    private val currencyStateFlow = MutableStateFlow<CurrencyModel?>(null)

    init {
        if (currentBaseValue.isEmpty())
            currentBaseValue = baseCurrencyValueList.first()
        coroutineScope.launch { refreshCurrencyStateFlow() }
    }

    suspend fun getCurrencyStateFlow(base: String): StateFlow<CurrencyModel?> {
        currentBaseValue = base
        refreshCurrencyStateFlow()
        return currencyStateFlow
    }

    private suspend fun refreshCurrencyStateFlow() {
        while (true) {
            delay(REFRESH_DELAY)
            currencyStateFlow.value = apiService.getCurrencyStateFlow(currentBaseValue)
        }
    }

    companion object {
        val REFRESH_DELAY = TimeUnit.SECONDS.toMillis(1)
    }
}
