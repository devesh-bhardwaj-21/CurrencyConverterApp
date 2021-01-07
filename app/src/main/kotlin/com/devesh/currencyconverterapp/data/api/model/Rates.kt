package com.devesh.currencyconverterapp.data.api.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Rates(
    @SerializedName("INR")
    val inr: BigDecimal = BigDecimal.ZERO,
    @SerializedName("CHF")
    val chf: BigDecimal = BigDecimal.ZERO,
    @SerializedName("HRK")
    val hrk: BigDecimal = BigDecimal.ZERO,
    @SerializedName("MXN")
    val mxn: BigDecimal = BigDecimal.ZERO,
    @SerializedName("ZAR")
    val zar: BigDecimal = BigDecimal.ZERO,
    @SerializedName("CNY")
    val cny: BigDecimal = BigDecimal.ZERO,
    @SerializedName("THB")
    val thb: BigDecimal = BigDecimal.ZERO,
    @SerializedName("AUD")
    val aud: BigDecimal = BigDecimal.ZERO,
    @SerializedName("ILS")
    val ils: BigDecimal = BigDecimal.ZERO,
    @SerializedName("KRW")
    val krw: BigDecimal = BigDecimal.ZERO,
    @SerializedName("JPY")
    val jpy: BigDecimal = BigDecimal.ZERO,
    @SerializedName("PLN")
    val pln: BigDecimal = BigDecimal.ZERO,
    @SerializedName("GBP")
    val gbp: BigDecimal = BigDecimal.ZERO,
    @SerializedName("IDR")
    val idr: BigDecimal = BigDecimal.ZERO,
    @SerializedName("HUF")
    val huf: BigDecimal = BigDecimal.ZERO,
    @SerializedName("PHP")
    val php: BigDecimal = BigDecimal.ZERO,
    @SerializedName("TRY")
    val TRY: BigDecimal = BigDecimal.ZERO,
    @SerializedName("RUB")
    val rub: BigDecimal = BigDecimal.ZERO,
    @SerializedName("HKD")
    val hkd: BigDecimal = BigDecimal.ZERO,
    @SerializedName("ISK")
    val isk: BigDecimal = BigDecimal.ZERO,
    @SerializedName("EUR")
    val eur: BigDecimal = BigDecimal.ZERO,
    @SerializedName("DKK")
    val dkk: BigDecimal = BigDecimal.ZERO,
    @SerializedName("CAD")
    val cad: BigDecimal = BigDecimal.ZERO,
    @SerializedName("MYR")
    val myr: BigDecimal = BigDecimal.ZERO,
    @SerializedName("USD")
    val usd: BigDecimal = BigDecimal.ZERO,
    @SerializedName("BGN")
    val bgn: BigDecimal = BigDecimal.ZERO,
    @SerializedName("NOK")
    val nok: BigDecimal = BigDecimal.ZERO,
    @SerializedName("RON")
    val ron: BigDecimal = BigDecimal.ZERO,
    @SerializedName("SGD")
    val sgd: BigDecimal = BigDecimal.ZERO,
    @SerializedName("CZK")
    val czk: BigDecimal = BigDecimal.ZERO,
    @SerializedName("SEK")
    val sek: BigDecimal = BigDecimal.ZERO,
    @SerializedName("NZD")
    val nzd: BigDecimal = BigDecimal.ZERO,
    @SerializedName("BRL")
    val brl: BigDecimal = BigDecimal.ZERO
)