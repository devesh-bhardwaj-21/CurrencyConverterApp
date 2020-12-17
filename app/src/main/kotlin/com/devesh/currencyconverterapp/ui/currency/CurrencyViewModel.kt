package com.devesh.currencyconverterapp.ui.currency

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devesh.currencyconverterapp.data.interactor.CurrencyInteractor
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal

@ExperimentalCoroutinesApi
class CurrencyViewModel @ViewModelInject constructor(private val interactor: CurrencyInteractor) :
    ViewModel() {

    private val _uiStateData = MutableLiveData<UiState>(UiState.InProgress)
    val uiStateLiveData get(): LiveData<UiState> = _uiStateData

    fun onBaseCurrencyValueChanged(uiCurrencyModel: UiCurrencyModel, uiCurrencyModelList: List<UiCurrencyModel>, adapterPosition: Int) {
        for (i in 0 until uiCurrencyModelList.size) {
            uiCurrencyModel.multiplier?.let { uiCurrencyModelList[i].multiplier?.div(it) }
            when (i) {
                in 0 until adapterPosition -> {
                    uiCurrencyModelList[i].multiplier = BigDecimal("1.0")
                }
            }
        }
    }

    fun onBaseValueChanged(base: String) {
        val exceptionHandler =
            CoroutineExceptionHandler { _, _ -> _uiStateData.postValue(UiState.Error) }
        viewModelScope.launch(exceptionHandler) {
            interactor.getCurrencyStateFlow(base)
                .catch { e ->
                    _uiStateData.postValue(UiState.Error)
                }
                .collect { _uiStateData.postValue(UiState.Success(it)) }
        }
    }

    sealed class UiState {
        data class Success(val data: List<UiCurrencyModel>) : UiState()
        object Error : UiState()
        object InProgress : UiState()
    }
}
