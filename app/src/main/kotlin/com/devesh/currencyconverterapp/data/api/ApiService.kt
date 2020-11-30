package com.devesh.currencyconverterapp.data.api

import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getCurrencyStateFlow(@Query("base") base: String): CurrencyModel?
}
