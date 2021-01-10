package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.data.api.model.Rates
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import com.devesh.currencyconverterapp.utils.CurrencyCode
import java.math.BigDecimal

object InteractorUtils {

    private val uiCurrencyMap = hashMapOf<String, Pair<Int, Int>>()

    init {
        uiCurrencyMap[CurrencyCode.USD.toString()] = Pair(R.drawable.ic_usd_flag, R.string.currency_usd_name)
        uiCurrencyMap[CurrencyCode.EUR.toString()] = Pair(R.drawable.ic_eur_flag, R.string.currency_eur_name)
        uiCurrencyMap[CurrencyCode.INR.toString()] = Pair(R.drawable.ic_inr_flag, R.string.currency_inr_name)
        uiCurrencyMap[CurrencyCode.CHF.toString()] = Pair(R.drawable.ic_chf_flag, R.string.currency_chf_name)
        uiCurrencyMap[CurrencyCode.HRK.toString()] = Pair(R.drawable.ic_hrk_flag, R.string.currency_hrk_name)
        uiCurrencyMap[CurrencyCode.MXN.toString()] = Pair(R.drawable.ic_mxn_flag, R.string.currency_mxn_name)
        uiCurrencyMap[CurrencyCode.ZAR.toString()] = Pair(R.drawable.ic_zar_flag, R.string.currency_zar_name)
        uiCurrencyMap[CurrencyCode.CNY.toString()] = Pair(R.drawable.ic_cny_flag, R.string.currency_cny_name)
        uiCurrencyMap[CurrencyCode.THB.toString()] = Pair(R.drawable.ic_thb_flag, R.string.currency_thb_name)
        uiCurrencyMap[CurrencyCode.AUD.toString()] = Pair(R.drawable.ic_aud_flag, R.string.currency_aud_name)
        uiCurrencyMap[CurrencyCode.ILS.toString()] = Pair(R.drawable.ic_ils_flag, R.string.currency_ils_name)
        uiCurrencyMap[CurrencyCode.KRW.toString()] = Pair(R.drawable.ic_krw_flag, R.string.currency_krw_name)
        uiCurrencyMap[CurrencyCode.JPY.toString()] = Pair(R.drawable.ic_jpy_flag, R.string.currency_jpy_name)
        uiCurrencyMap[CurrencyCode.PLN.toString()] = Pair(R.drawable.ic_pln_flag, R.string.currency_pln_name)
        uiCurrencyMap[CurrencyCode.GBP.toString()] = Pair(R.drawable.ic_gbp_flag, R.string.currency_gbp_name)
        uiCurrencyMap[CurrencyCode.IDR.toString()] = Pair(R.drawable.ic_idr_flag, R.string.currency_idr_name)
        uiCurrencyMap[CurrencyCode.HUF.toString()] = Pair(R.drawable.ic_huf_flag, R.string.currency_huf_name)
        uiCurrencyMap[CurrencyCode.PHP.toString()] = Pair(R.drawable.ic_php_flag, R.string.currency_php_name)
        uiCurrencyMap[CurrencyCode.TRY.toString()] = Pair(R.drawable.ic_try_flag, R.string.currency_try_name)
        uiCurrencyMap[CurrencyCode.RUB.toString()] = Pair(R.drawable.ic_rub_flag, R.string.currency_rub_name)
        uiCurrencyMap[CurrencyCode.HKD.toString()] = Pair(R.drawable.ic_hkd_flag, R.string.currency_hkd_name)
        uiCurrencyMap[CurrencyCode.ISK.toString()] = Pair(R.drawable.ic_isk_flag, R.string.currency_isk_name)
        uiCurrencyMap[CurrencyCode.DKK.toString()] = Pair(R.drawable.ic_dkk_flag, R.string.currency_dkk_name)
        uiCurrencyMap[CurrencyCode.CAD.toString()] = Pair(R.drawable.ic_cad_flag, R.string.currency_cad_name)
        uiCurrencyMap[CurrencyCode.MYR.toString()] = Pair(R.drawable.ic_myr_flag, R.string.currency_myr_name)
        uiCurrencyMap[CurrencyCode.BGN.toString()] = Pair(R.drawable.ic_bgn_flag, R.string.currency_bgn_name)
        uiCurrencyMap[CurrencyCode.NOK.toString()] = Pair(R.drawable.ic_nok_flag, R.string.currency_nok_name)
        uiCurrencyMap[CurrencyCode.RON.toString()] = Pair(R.drawable.ic_ron_flag, R.string.currency_ron_name)
        uiCurrencyMap[CurrencyCode.SGD.toString()] = Pair(R.drawable.ic_sgd_flag, R.string.currency_sgd_name)
        uiCurrencyMap[CurrencyCode.CZK.toString()] = Pair(R.drawable.ic_czk_flag, R.string.currency_czk_name)
        uiCurrencyMap[CurrencyCode.SEK.toString()] = Pair(R.drawable.ic_sek_flag, R.string.currency_sek_name)
        uiCurrencyMap[CurrencyCode.NZD.toString()] = Pair(R.drawable.ic_nzd_flag, R.string.currency_nzd_name)
        uiCurrencyMap[CurrencyCode.BRL.toString()] = Pair(R.drawable.ic_brl_flag, R.string.currency_brl_name)
    }

    fun convertCurrencyToMap(rates: Rates): HashMap<String, BigDecimal> {
        val uiCurrencyRateMap = hashMapOf<String, BigDecimal>()
        uiCurrencyRateMap[CurrencyCode.USD.toString()] = rates.usd
        uiCurrencyRateMap[CurrencyCode.EUR.toString()] = rates.eur
        uiCurrencyRateMap[CurrencyCode.INR.toString()] = rates.inr
        uiCurrencyRateMap[CurrencyCode.CHF.toString()] = rates.chf
        uiCurrencyRateMap[CurrencyCode.HRK.toString()] = rates.hrk
        uiCurrencyRateMap[CurrencyCode.MXN.toString()] = rates.mxn
        uiCurrencyRateMap[CurrencyCode.ZAR.toString()] = rates.zar
        uiCurrencyRateMap[CurrencyCode.CNY.toString()] = rates.cny
        uiCurrencyRateMap[CurrencyCode.THB.toString()] = rates.thb
        uiCurrencyRateMap[CurrencyCode.AUD.toString()] = rates.aud
        uiCurrencyRateMap[CurrencyCode.ILS.toString()] = rates.ils
        uiCurrencyRateMap[CurrencyCode.KRW.toString()] = rates.krw
        uiCurrencyRateMap[CurrencyCode.JPY.toString()] = rates.jpy
        uiCurrencyRateMap[CurrencyCode.PLN.toString()] = rates.pln
        uiCurrencyRateMap[CurrencyCode.GBP.toString()] = rates.gbp
        uiCurrencyRateMap[CurrencyCode.IDR.toString()] = rates.idr
        uiCurrencyRateMap[CurrencyCode.HUF.toString()] = rates.huf
        uiCurrencyRateMap[CurrencyCode.PHP.toString()] = rates.php
        uiCurrencyRateMap[CurrencyCode.TRY.toString()] = rates.TRY
        uiCurrencyRateMap[CurrencyCode.RUB.toString()] = rates.rub
        uiCurrencyRateMap[CurrencyCode.HKD.toString()] = rates.hkd
        uiCurrencyRateMap[CurrencyCode.ISK.toString()] = rates.isk
        uiCurrencyRateMap[CurrencyCode.DKK.toString()] = rates.dkk
        uiCurrencyRateMap[CurrencyCode.CAD.toString()] = rates.cad
        uiCurrencyRateMap[CurrencyCode.MYR.toString()] = rates.myr
        uiCurrencyRateMap[CurrencyCode.BGN.toString()] = rates.bgn
        uiCurrencyRateMap[CurrencyCode.NOK.toString()] = rates.nok
        uiCurrencyRateMap[CurrencyCode.RON.toString()] = rates.ron
        uiCurrencyRateMap[CurrencyCode.SGD.toString()] = rates.sgd
        uiCurrencyRateMap[CurrencyCode.CZK.toString()] = rates.czk
        uiCurrencyRateMap[CurrencyCode.SEK.toString()] = rates.sek
        uiCurrencyRateMap[CurrencyCode.NZD.toString()] = rates.nzd
        uiCurrencyRateMap[CurrencyCode.BRL.toString()] = rates.brl
        return uiCurrencyRateMap
    }

    fun mapServerDataToUiData(currencyModel: CurrencyModel): List<UiCurrencyModel> {
        val uiCurrencyList: MutableList<UiCurrencyModel> = arrayListOf()
        val currencyRateMap = convertCurrencyToMap(currencyModel.rates)
        uiCurrencyMap.forEach { (key, value) ->
            uiCurrencyList.add(
                UiCurrencyModel(
                    key,
                    currencyRateMap.getValue(key),
                    value.first,
                    value.second
                )
            )
        }
        return uiCurrencyList
    }
}