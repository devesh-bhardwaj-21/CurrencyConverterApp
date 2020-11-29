package com.devesh.currencyconverterapp.data.api.model

data class Rate(
    val key: String,
    val name: String,
    val multiplier: Double,
    val position: Int = 0,
    val value: Double? = null
)
