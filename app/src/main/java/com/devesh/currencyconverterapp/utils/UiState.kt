package com.devesh.currencyconverterapp.utils

import com.devesh.currencyconverterapp.data.api.model.RemoteRate

sealed class UiState {
    data class Success(val data: RemoteRate?) : UiState()
    object Error : UiState()
    object InProgress : UiState()
}