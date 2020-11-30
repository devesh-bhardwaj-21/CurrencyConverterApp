package com.devesh.currencyconverterapp.ui.currency

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devesh.currencyconverterapp.data.interactor.CurrencyInteractor
import com.devesh.currencyconverterapp.utils.UiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class CurrencyViewModel @ViewModelInject constructor(private val interactor: CurrencyInteractor) :
    ViewModel() {

    private val _uiStateData = MutableLiveData<UiState>(UiState.InProgress)
    val uiStateLiveData get(): LiveData<UiState> = _uiStateData

    init {
        val exceptionHandler =
            CoroutineExceptionHandler { _, _ -> _uiStateData.postValue(UiState.Error) }
        viewModelScope.launch(exceptionHandler) {
            interactor.getCurrencyStateFlow()
                .catch { e ->
                    _uiStateData.postValue(UiState.Error)
                }
                .collect { _uiStateData.postValue(UiState.Success(it)) }
        }
    }

    fun onBaseValueChanged(value: String) {
        interactor.onBaseValueChanged(value)
    }

    fun onBaseCurrencyValueChanged(value: String) {
        interactor.onBaseCurrencyValueChanged(value)
    }
}
