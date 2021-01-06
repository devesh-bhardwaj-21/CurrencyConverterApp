package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.data.api.model.Rates
import com.devesh.currencyconverterapp.utils.AppConstants
import java.math.BigDecimal

object InteractorUtils {

    val uiCurrencyMap = hashMapOf<String, Pair<Int, Int>>()

    init {
        uiCurrencyMap[AppConstants.CURRENCY_CODE_USD] = Pair(R.drawable.ic_usd_flag, R.string.currency_usd_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_EUR] = Pair(R.drawable.ic_eur_flag, R.string.currency_eur_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_CHF] = Pair(R.drawable.ic_chf_flag, R.string.currency_chf_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_HRK] = Pair(R.drawable.ic_hrk_flag, R.string.currency_hrk_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_MXN] = Pair(R.drawable.ic_mxn_flag, R.string.currency_mxn_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_ZAR] = Pair(R.drawable.ic_zar_flag, R.string.currency_zar_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_CNY] = Pair(R.drawable.ic_cny_flag, R.string.currency_cny_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_THB] = Pair(R.drawable.ic_thb_flag, R.string.currency_thb_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_AUD] = Pair(R.drawable.ic_aud_flag, R.string.currency_aud_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_ILS] = Pair(R.drawable.ic_ils_flag, R.string.currency_ils_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_KRW] = Pair(R.drawable.ic_krw_flag, R.string.currency_krw_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_JPY] = Pair(R.drawable.ic_jpy_flag, R.string.currency_jpy_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_PLN] = Pair(R.drawable.ic_pln_flag, R.string.currency_pln_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_GBP] = Pair(R.drawable.ic_gbp_flag, R.string.currency_gbp_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_IDR] = Pair(R.drawable.ic_idr_flag, R.string.currency_idr_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_HUF] = Pair(R.drawable.ic_huf_flag, R.string.currency_huf_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_PHP] = Pair(R.drawable.ic_php_flag, R.string.currency_php_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_TRY] = Pair(R.drawable.ic_try_flag, R.string.currency_try_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_RUB] = Pair(R.drawable.ic_rub_flag, R.string.currency_rub_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_HKD] = Pair(R.drawable.ic_hkd_flag, R.string.currency_hkd_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_ISK] = Pair(R.drawable.ic_isk_flag, R.string.currency_isk_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_DKK] = Pair(R.drawable.ic_dkk_flag, R.string.currency_dkk_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_CAD] = Pair(R.drawable.ic_cad_flag, R.string.currency_cad_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_MYR] = Pair(R.drawable.ic_myr_flag, R.string.currency_myr_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_BGN] = Pair(R.drawable.ic_bgn_flag, R.string.currency_bgn_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_NOK] = Pair(R.drawable.ic_nok_flag, R.string.currency_nok_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_RON] = Pair(R.drawable.ic_ron_flag, R.string.currency_ron_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_SGD] = Pair(R.drawable.ic_sgd_flag, R.string.currency_sgd_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_CZK] = Pair(R.drawable.ic_czk_flag, R.string.currency_czk_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_SEK] = Pair(R.drawable.ic_sek_flag, R.string.currency_sek_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_NZD] = Pair(R.drawable.ic_nzd_flag, R.string.currency_nzd_name)
        uiCurrencyMap[AppConstants.CURRENCY_CODE_BRL] = Pair(R.drawable.ic_brl_flag, R.string.currency_brl_name)
    }

    fun convertCurrencyToMap(rates: Rates): HashMap<String, BigDecimal> {
        val uiCurrencyRateMap = hashMapOf<String, BigDecimal>()
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_USD] = rates.usd
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_EUR] = rates.eur
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_CHF] = rates.chf
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_HRK] = rates.hrk
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_MXN] = rates.mxn
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_ZAR] = rates.zar
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_CNY] = rates.cny
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_THB] = rates.thb
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_AUD] = rates.aud
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_ILS] = rates.ils
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_KRW] = rates.krw
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_JPY] = rates.jpy
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_PLN] = rates.pln
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_GBP] = rates.gbp
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_IDR] = rates.idr
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_HUF] = rates.huf
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_PHP] = rates.php
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_TRY] = rates.TRY
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_RUB] = rates.rub
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_HKD] = rates.hkd
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_ISK] = rates.isk
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_DKK] = rates.dkk
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_CAD] = rates.cad
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_MYR] = rates.myr
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_BGN] = rates.bgn
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_NOK] = rates.nok
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_RON] = rates.ron
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_SGD] = rates.sgd
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_CZK] = rates.czk
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_SEK] = rates.sek
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_NZD] = rates.nzd
        uiCurrencyRateMap[AppConstants.CURRENCY_CODE_BRL] = rates.brl
        return uiCurrencyRateMap
    }
}