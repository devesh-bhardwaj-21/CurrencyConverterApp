package com.devesh.currencyconverterapp.ui.currency

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.data.api.model.Rates
import com.devesh.currencyconverterapp.data.interactor.CurrencyInteractor
import com.devesh.currencyconverterapp.data.interactor.InteractorUtils
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import com.devesh.currencyconverterapp.utils.baseCurrencyValueList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.concurrent.CopyOnWriteArrayList

@ExperimentalCoroutinesApi
class CurrencyViewModel @ViewModelInject constructor(private val interactor: CurrencyInteractor) :
    ViewModel() {

    private val _uiStateFlow = MutableStateFlow<UiState>(UiState.InProgress)
    val uiStateFlow get(): StateFlow<UiState> = _uiStateFlow
    private val jobs: MutableList<Job> = mutableListOf()
    private var multiplier = BigDecimal("1.0")


    init {
        getCurrencyStateFlow(baseCurrencyValueList.first().toString(), false)
    }

    fun getCurrencyStateFlow(base: String, hasBaseCurrencyChanged: Boolean) {
        if (jobs.isNotEmpty()) {
            jobs.forEach { it.cancel() }
            jobs.clear()
        }
        if (hasBaseCurrencyChanged) {
            _uiStateFlow.value = UiState.BaseCurrencyChanged
        }
        val exceptionHandler =
            CoroutineExceptionHandler { _, _ -> _uiStateFlow.value = UiState.Error }
        val job = viewModelScope.launch(exceptionHandler) {
            interactor.getCurrencyStateFlow(base)
                .catch { e ->
                    _uiStateFlow.value = UiState.Error
                    emit(InteractorUtils.mapServerDataToUiData(CurrencyModel("", Rates(), "")))
                }
                .collectLatest { uiCurrencyModelList ->
                    val uiStateList: CopyOnWriteArrayList<UiCurrencyModel> =
                        CopyOnWriteArrayList(uiCurrencyModelList)
                    uiStateList.forEach { uiCurrencyModel ->
                        uiCurrencyModel.currencyValue =
                            uiCurrencyModel.currencyValue?.times(multiplier)
                                ?.setScale(2, BigDecimal.ROUND_HALF_EVEN)
                    }
                    if (hasBaseCurrencyChanged) {
                        uiStateList.forEach { uiCurrencyModel ->
                            if (uiCurrencyModel.currencyCode == base) {
                                uiStateList.remove(uiCurrencyModel).also {
                                    uiStateList.add(0, uiCurrencyModel)
                                }
                            }
                        }
                        _uiStateFlow.value = UiState.Success(uiStateList)
                    } else {
                        _uiStateFlow.value = UiState.Success(uiStateList)
                    }
                }
        }
        jobs.add(job)
    }

    fun onBaseCurrencyValueChanged(
        newBaseCurrencyValue: BigDecimal?,
        baseCurrency: String
    ) {
        newBaseCurrencyValue ?: return
        _uiStateFlow.value.let { uiState ->
            if (uiState is UiState.Success) {
                calculateMultiplier(uiState.data, newBaseCurrencyValue, baseCurrency)
            }
        }
    }

    private fun calculateMultiplier(
        uiCurrencyModelList: List<UiCurrencyModel>,
        newBaseCurrencyValue: BigDecimal,
        baseCurrency: String
    ) {
        uiCurrencyModelList.forEach { uiCurrencyModel ->
            val currencyValue =
                uiCurrencyModel.currencyValue?.takeIf { uiCurrencyModel.currencyCode == baseCurrency && it > BigDecimal.ZERO }
            currencyValue ?: return@forEach
            multiplier = newBaseCurrencyValue.div(currencyValue)
            return@forEach
        }
    }

    sealed class UiState {
        class Success(val data: List<UiCurrencyModel>) : UiState()
        object Error : UiState()
        object InProgress : UiState()
        object BaseCurrencyChanged : UiState()
    }
}
