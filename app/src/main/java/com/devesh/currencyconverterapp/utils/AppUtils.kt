package com.devesh.currencyconverterapp.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

fun showNoDataError(view: View?, errorMessage: String) {
    val snackBar = view?.let {
        Snackbar.make(
            it, errorMessage,
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

val baseCurrencyValueList = arrayListOf("EUR", "USD", "INR", "RUB")


inline class BaseUrl(val baseUrl: String)

val baseUrl: BaseUrl = BaseUrl("https://revolut.duckdns.org/")

class AppConstants {
    companion object {
        const val timeoutConnect = 30
        const val timeoutRead = 30
    }
}


