package com.devesh.currencyconverterapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getCurrencyStateFlow(@Query("base") base: String): RemoteRate?
}
