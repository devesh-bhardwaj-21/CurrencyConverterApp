package com.devesh.currencyconverterapp.data.api

import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("currency")
    suspend fun getCurrencyModel(): CurrencyModel

    @GET("currency/{base}")
    suspend fun getCurrencyModel(@Path("base") base: String): CurrencyModel
}
