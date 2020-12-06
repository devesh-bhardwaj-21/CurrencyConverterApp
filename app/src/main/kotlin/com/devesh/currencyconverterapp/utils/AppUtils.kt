package com.devesh.currencyconverterapp.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


fun showNoDataError(view: View?, errorMessage: String) {
    val snackBar = view?.let {
        Snackbar.make(
            it,
            errorMessage,
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
    }
    snackBar?.setActionTextColor(Color.BLUE)
    val snackBarView = snackBar?.view
    snackBarView?.setBackgroundColor(Color.CYAN)
    val textView =
        snackBarView?.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    textView.setTextColor(Color.BLUE)
    snackBar.show()
}

val baseCurrencyValueList = arrayListOf(
    "USD",
    "EUR",
    "CHF",
    "HRK",
    "MXN",
    "ZAR",
    "CNY",
    "THB",
    "AUD",
    "ILS",
    "KRW",
    "JPY",
    "PLN",
    "GBP",
    "IDR",
    "HUF",
    "PHP",
    "TRY",
    "RUB",
    "HKD",
    "ISK",
    "DKK",
    "CAD",
    "MYR",
    "BGN",
    "NOK",
    "RON",
    "SGD",
    "CZK",
    "SEK",
    "NZD",
    "BRL",
    "INR"
)

