package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.data.repository.CurrencyRepository
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyInteractor @Inject constructor(private val repository: CurrencyRepository) {

    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private val uiCurrencyList: MutableList<UiCurrencyModel> = arrayListOf()
    private val currencyStateFlow = MutableStateFlow<List<UiCurrencyModel>>(uiCurrencyList)

    fun getCurrencyStateFlow(base: String): StateFlow<List<UiCurrencyModel>> {
        val exceptionHandler =
            CoroutineExceptionHandler { _, _ ->
                MutableStateFlow<List<UiCurrencyModel>>(
                    uiCurrencyList
                )
            }
        coroutineScope.launch(exceptionHandler) {
            repository.getCurrencyStateFlow(base)
                .catch { e ->
                    Timber.e(e.localizedMessage)
                    emit(null)
                }
                .collect {
                    it?.let {
                        uiCurrencyList.clear()
                        InteractorUtils().uiCurrencyMap.forEach { (key, value) ->
                            uiCurrencyList.add(
                                UiCurrencyModel(
                                    key,
                                    InteractorUtils().convertCurrencyToMap(it.rates).getValue(key)
                                        .toBigDecimal(),
                                    value.first,
                                    value.second
                                )
                            )
                        }
                    }
                }
        }
        currencyStateFlow.value = uiCurrencyList
        return currencyStateFlow
    }

}
