package com.devesh.currencyconverterapp.utils

sealed class UiState {
    data class Success(val data: RemoteRate) : UiState()
    object Error : UiState()
    object InProgress : UiState()
}
