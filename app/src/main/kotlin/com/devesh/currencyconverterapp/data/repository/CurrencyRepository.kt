package com.devesh.currencyconverterapp.data.repository

import com.devesh.currencyconverterapp.data.api.ApiService
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyRepository @Inject constructor(private val apiService: ApiService) {

    private lateinit var currencyFlow: Flow<CurrencyModel>

    fun getCurrencyFlow(base: String): Flow<CurrencyModel> {
        currencyFlow = flow {
            while (true) {
                val currencies = apiService.getCurrencyStateFlow(base)
                emit(currencies)
                delay(REFRESH_DELAY)
            }
        }
        return currencyFlow
    }

    private companion object {
        const val REFRESH_DELAY = 1000L
    }
}
