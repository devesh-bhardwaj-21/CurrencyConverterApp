package com.devesh.currencyconverterapp.data.api.model

import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("base")
    val base: String = ""
)