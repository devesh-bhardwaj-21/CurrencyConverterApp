package com.devesh.currencyconverterapp.data.interactor

import com.devesh.currencyconverterapp.data.api.model.CurrencyModel
import com.devesh.currencyconverterapp.data.api.model.Rates
import com.devesh.currencyconverterapp.data.interactor.InteractorUtils.mapServerDataToUiData
import com.devesh.currencyconverterapp.data.repository.CurrencyRepository
import com.devesh.currencyconverterapp.ui.currency.uimodel.UiCurrencyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CurrencyInteractor @Inject constructor(private val repository: CurrencyRepository) {

    fun getCurrencyStateFlow(base: String): Flow<List<UiCurrencyModel>> {
        return repository.getCurrencyFlow(base)
            .catch { e ->
                Timber.e(e.localizedMessage)
                emit(CurrencyModel("", Rates(), ""))
            }
            .map { currencyModel -> mapServerDataToUiData(currencyModel) }
            .flowOn(Dispatchers.IO)
    }
}
