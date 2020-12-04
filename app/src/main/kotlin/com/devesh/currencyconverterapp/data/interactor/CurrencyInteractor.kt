package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.R
import com.devesh.currencyconverterapp.data.repository.CurrencyRepository
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import com.devesh.currencyconverterapp.utils.AppConstants
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyInteractor @Inject constructor(private val repository: CurrencyRepository) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    
    fun getCurrencyStateFlow(base: String): StateFlow<List<UiCurrencyModel>> {
        val uiCurrencyList: MutableList<UiCurrencyModel> = arrayListOf()
        val exceptionHandler =
            CoroutineExceptionHandler { _, _ -> MutableStateFlow<List<UiCurrencyModel>>(uiCurrencyList) }
        coroutineScope.launch(exceptionHandler) {
        repository.getCurrencyStateFlow(base)
            .catch { e ->
                return@catch
            }
            .collect {
                it?.let {
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_USD,
                            it.rates.usd,
                            R.drawable.ic_usd_flag,
                            R.string.currency_usd_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_EUR,
                            it.rates.eur,
                            R.drawable.ic_eur_flag,
                            R.string.currency_eur_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_CHF,
                            it.rates.chf,
                            R.drawable.ic_chf_flag,
                            R.string.currency_chf_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_HRK,
                            it.rates.hrk,
                            R.drawable.ic_hrk_flag,
                            R.string.currency_hrk_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_MXN,
                            it.rates.mxn,
                            R.drawable.ic_mxn_flag,
                            R.string.currency_mxn_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_ZAR,
                            it.rates.zar,
                            R.drawable.ic_zar_flag,
                            R.string.currency_zar_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_CNY,
                            it.rates.cny,
                            R.drawable.ic_cny_flag,
                            R.string.currency_cny_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_THB,
                            it.rates.thb,
                            R.drawable.ic_thb_flag,
                            R.string.currency_thb_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_AUD,
                            it.rates.aud,
                            R.drawable.ic_aud_flag,
                            R.string.currency_aud_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_ILS,
                            it.rates.ils,
                            R.drawable.ic_ils_flag,
                            R.string.currency_ils_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_KRW,
                            it.rates.krw,
                            R.drawable.ic_krw_flag,
                            R.string.currency_krw_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_JPY,
                            it.rates.jpy,
                            R.drawable.ic_jpy_flag,
                            R.string.currency_jpy_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_PLN,
                            it.rates.pln,
                            R.drawable.ic_pln_flag,
                            R.string.currency_pln_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_GBP,
                            it.rates.gbp,
                            R.drawable.ic_gbp_flag,
                            R.string.currency_gbp_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_IDR,
                            it.rates.idr,
                            R.drawable.ic_idr_flag,
                            R.string.currency_idr_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_HUF,
                            it.rates.huf,
                            R.drawable.ic_huf_flag,
                            R.string.currency_huf_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_PHP,
                            it.rates.php,
                            R.drawable.ic_php_flag,
                            R.string.currency_php_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_TRY,
                            it.rates.TRY,
                            R.drawable.ic_try_flag,
                            R.string.currency_try_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_RUB,
                            it.rates.rub,
                            R.drawable.ic_rub_flag,
                            R.string.currency_rub_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_HKD,
                            it.rates.hkd,
                            R.drawable.ic_hkd_flag,
                            R.string.currency_hkd_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_ISK,
                            it.rates.isk,
                            R.drawable.ic_isk_flag,
                            R.string.currency_isk_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_DKK,
                            it.rates.dkk,
                            R.drawable.ic_dkk_flag,
                            R.string.currency_dkk_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_CAD,
                            it.rates.cad,
                            R.drawable.ic_cad_flag,
                            R.string.currency_cad_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_MYR,
                            it.rates.myr,
                            R.drawable.ic_myr_flag,
                            R.string.currency_myr_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_BGN,
                            it.rates.bgn,
                            R.drawable.ic_bgn_flag,
                            R.string.currency_bgn_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_NOK,
                            it.rates.nok,
                            R.drawable.ic_nok_flag,
                            R.string.currency_nok_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_RON,
                            it.rates.ron,
                            R.drawable.ic_ron_flag,
                            R.string.currency_ron_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_SGD,
                            it.rates.sgd,
                            R.drawable.ic_sgd_flag,
                            R.string.currency_sgd_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_CZK,
                            it.rates.czk,
                            R.drawable.ic_czk_flag,
                            R.string.currency_czk_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_SEK,
                            it.rates.sek,
                            R.drawable.ic_sek_flag,
                            R.string.currency_sek_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_NZD,
                            it.rates.nzd,
                            R.drawable.ic_nzd_flag,
                            R.string.currency_nzd_name
                        )
                    )
                    uiCurrencyList.add(
                        UiCurrencyModel(
                            AppConstants.CURRENCY_CODE_BRL,
                            it.rates.brl,
                            R.drawable.ic_brl_flag,
                            R.string.currency_brl_name
                        )
                    )
                }
            }
    }

        return MutableStateFlow<List<UiCurrencyModel>>(uiCurrencyList)
    }

    fun onBaseCurrencyValueChanged(base: String, value: Double) {
       // repository.getCurrencyStateFlow(base)
    }

}
