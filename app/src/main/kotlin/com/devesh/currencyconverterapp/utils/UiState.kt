package com.devesh.currencyconverterapp.utils

import com.devesh.currencyconverterapp.data.api.model.CurrencyModel

sealed class UiState {
    data class Success(val data: CurrencyModel) : UiState()
    object Error : UiState()
    object InProgress : UiState()
}
