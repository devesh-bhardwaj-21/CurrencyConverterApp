package com.devesh.currencyconverterapp.ui.currency.uimodel

class UiCurrencyModel(
    val currencyCode: String = "",
    var currencyValue: Double? = 0.0,
    val currencyFlagId: Int = 0,
    val currencyNameId: Int = 0,
) {
    var multiplier: Double = 1.0
}