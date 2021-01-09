package com.devesh.currencyconverterapp.data.repository

import com.devesh.currencyconverterapp.data.api.ApiService
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val REFRESH_DELAY = 1000L

@ExperimentalCoroutinesApi
class CurrencyRepository @Inject constructor(private val apiService: ApiService) {

    fun getCurrencyFlow(base: String): Flow<CurrencyModel> {
         return flow {
            while (true) {
                val currencies = apiService.getCurrencyStateFlow(base)
                emit(currencies)
                delay(REFRESH_DELAY)
            }
        }
    }
}
