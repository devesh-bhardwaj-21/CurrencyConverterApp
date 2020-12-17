package com.devesh.currencyconverterapp.ui.currency.uimodel

import java.math.BigDecimal

class UiCurrencyModel(
    val currencyCode: String = "",
    var currencyValue: BigDecimal?,
    val currencyFlagId: Int = 0,
    val currencyNameId: Int = 0,
) {
    var multiplier: BigDecimal? = null
}