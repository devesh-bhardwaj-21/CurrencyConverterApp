package com.devesh.currencyconverterapp.data.api.model

data class RemoteRate (
    val base: String = "",
    val date: String = "",
    val rates: List<Rate>
)