package com.devesh.currencyconverterapp.data.api

import com.devesh.currencyconverterapp.data.api.model.RemoteRate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @ExperimentalCoroutinesApi
    @GET("latest")
    suspend fun getCurrencyStateFlow(@Query("base") base: String): RemoteRate?
}