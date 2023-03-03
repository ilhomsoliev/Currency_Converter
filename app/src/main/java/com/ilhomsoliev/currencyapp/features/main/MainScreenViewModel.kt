package com.ilhomsoliev.currencyapp.features.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.currencyapp.core.DataStoreManager
import com.ilhomsoliev.currencyapp.core.Helper
import com.ilhomsoliev.currencyapp.core.Resource
import com.ilhomsoliev.currencyapp.core.getCountryIdByName
import com.ilhomsoliev.currencyapp.data.local.dao.CurrenciesDao
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity
import com.ilhomsoliev.currencyapp.domain.model.Currency
import com.ilhomsoliev.currencyapp.domain.use_cases.GetCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    application: Application,
    private val getCurrencyUseCase: GetCurrencyUseCase,
    private val dataStoreManager: DataStoreManager,
    private val dao: CurrenciesDao,
) : AndroidViewModel(application) {
    val jobFrom: CoroutineScope = viewModelScope
    val jobTo: CoroutineScope = CoroutineScope(Dispatchers.IO)
    private val _state = MutableStateFlow(MainState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        MainState()
    )

    init {
        dataStoreManager.getFromCurrencyId.onEach { currencyId ->
            if (currencyId == -1) {
                dataStoreManager.updateFromCurrency(getCountryIdByName(application.applicationContext))
            } else {
                viewModelScope.launch {
                    val fromCurrency = dao.getCurrencyById(currencyId)
                    if (fromCurrency?.initials != _state.value.fromCurrencyIni) {
                        _state.update {
                            it.copy(
                                fromCurrencyIni = fromCurrency?.initials,
                                fromCurrencySymbol = Helper.getAllCurrencies()
                                    .filter { it.initials == fromCurrency?.initials }[0].countryFlagLink,
                                fromCurrencyId = currencyId,
                            )
                        }
                        getCurrency()
                    }
                }
            }
        }.launchIn(viewModelScope)

        dataStoreManager.getToCurrencyId.onEach { currencyId ->
            if (currencyId == -1) {
                dataStoreManager.updateToCurrency(getCountryIdByName(application.applicationContext))
            } else {
                viewModelScope.launch {
                    val toCurrency = dao.getCurrencyById(currencyId)
                    if (toCurrency?.initials != _state.value.toCurrencyIni) {
                        _state.update {
                            it.copy(
                                toCurrencyIni = toCurrency?.initials,
                                toCurrencySymbol = Helper.getAllCurrencies()
                                    .filter { it.initials == toCurrency?.initials }[0].countryFlagLink,
                                toCurrencyId = currencyId,
                            )
                        }
                        getCurrency()
                    }
                }
            }
        }.launchIn(viewModelScope)

        dataStoreManager.getLastUpdateTime.onEach { time ->
            _state.update {
                it.copy(
                    lastUpdateTime = time
                )
            }
        }.launchIn(viewModelScope)

    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.Refresh -> {
                getCurrency()
            }
            is MainEvent.Number -> enterNumber(event.number)
            is MainEvent.Delete -> delete()
            is MainEvent.Clear -> _state.update {
                it.copy(
                    fromCurrencyAmount1 = "",
                    fromCurrencyAmount2 = "",
                    operation = null,
                )
            }
            is MainEvent.Operation -> enterOperation(event.operation)
            is MainEvent.Decimal -> enterDecimal()
            is MainEvent.Calculate -> calculate()
            is MainEvent.OnPasteAmount -> {
                _state.update {
                    it.copy(
                        fromCurrencyAmount1 = event.text,
                        fromCurrencyAmount2 = "",
                        operation = null,
                    )
                }
            }
            is MainEvent.ReverseCurrencies -> {
                _state.update {
                    it.copy(
                        fromCurrencyIni = _state.value.toCurrencyIni,
                        fromCurrencySymbol = _state.value.toCurrencySymbol,
                        fromCurrencyAmount1 = _state.value.toCurrencyAmount,
                        toCurrencyAmount = _state.value.fromCurrencyAmount1,
                        toCurrencyIni = _state.value.fromCurrencyIni,
                        toCurrencySymbol = _state.value.fromCurrencySymbol,
                        fromCurrencyId = _state.value.toCurrencyId,
                        toCurrencyId = _state.value.fromCurrencyId,
                        fromCurrencyAmount2 = "",
                        //        exchangeRate = 1f / _state.value.exchangeRate,
                        operation = null
                    )
                }
                viewModelScope.launch {
                    _state.value.fromCurrencyId?.let { dataStoreManager.updateFromCurrency(it) }
                    _state.value.toCurrencyId?.let { dataStoreManager.updateToCurrency(it) }

                }

                getCurrency()
            }
            else -> Unit
        }
    }

    private fun getCurrency() {
        if (state.value.fromCurrencyIni == state.value.toCurrencyIni) return
        state.value.fromCurrencyIni?.let { fromCurrencyIni ->
            state.value.toCurrencyIni?.let { toCurrencyIni ->
                getCurrencyUseCase(
                    fromCurrencyIni.lowercase(Locale.ROOT),
                    toCurrencyIni.lowercase(Locale.ROOT)
                ).onEach { result: Resource<Double> ->
                    when (result) {
                        is Resource.Success -> {
                            try {
                                _state.update {
                                    it.copy(
                                        exchangeRate = result.data!!,
                                        isLoading = false,
                                    )
                                }
                                dataStoreManager.updateLastUpdate(System.currentTimeMillis())
                            } catch (e: java.lang.Exception) {
                                _state.update {
                                    it.copy(
                                        error = result.message ?: "An unexpected error occured"
                                    )
                                }
                            }
                        }
                        is Resource.Error -> {
                            _state.update {
                                it.copy(
                                    error = result.message ?: "An unexpected error occured"
                                )
                            }
                        }
                        is Resource.Loading -> {
                            _state.update {
                                it.copy(
                                    isLoading = true,
                                )
                            }
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (_state.value.fromCurrencyAmount1.isNotBlank()) {
            _state.update {
                it.copy(operation = operation)
            }
        }
    }

    private fun calculate() {
        if (_state.value.fromCurrencyAmount1.isEmpty() || _state.value.fromCurrencyAmount2.isEmpty()) {
            return
        }
        val number1 = _state.value.fromCurrencyAmount1.toDoubleOrNull()
        val number2 = _state.value.fromCurrencyAmount2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.value.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            _state.update {
                it.copy(
                    fromCurrencyAmount1 = result.toString().take(12),//.take(15),
                    fromCurrencyAmount2 = "",
                    operation = null
                )
            }
        }
    }

    private fun delete() {
        when {
            _state.value.fromCurrencyAmount2.isNotBlank() -> _state.update {
                it.copy(
                    fromCurrencyAmount2 = _state.value.fromCurrencyAmount2.dropLast(1)
                )
            }
            _state.value.operation != null -> _state.update {
                it.copy(
                    operation = null
                )
            }
            _state.value.fromCurrencyAmount1.isNotBlank() -> _state.update {
                it.copy(
                    fromCurrencyAmount1 = _state.value.fromCurrencyAmount1.dropLast(1)
                )
            }
        }
    }

    private fun enterDecimal() {
        if (_state.value.operation == null && !_state.value.fromCurrencyAmount1.contains(".") && _state.value.fromCurrencyAmount2.isNotBlank()) {
            _state.update {
                it.copy(
                    fromCurrencyAmount1 = _state.value.fromCurrencyAmount1 + "."
                )
            }
            return
        } else if (!_state.value.fromCurrencyAmount2.contains(".") && _state.value.fromCurrencyAmount2.isNotBlank()) {
            _state.update {
                it.copy(
                    fromCurrencyAmount2 = _state.value.fromCurrencyAmount2 + "."
                )
            }
        }
    }

    private fun enterNumber(number: Int) {
        if (_state.value.operation == null) {
            if (_state.value.fromCurrencyAmount1.length >= MAX_NUM_LENGTH) {
                return
            }
            _state.update {
                it.copy(
                    fromCurrencyAmount1 = _state.value.fromCurrencyAmount1 + number
                )
            }
            return
        }
        if (_state.value.fromCurrencyAmount2.length >= MAX_NUM_LENGTH) {
            return
        }
        _state.update {
            it.copy(
                fromCurrencyAmount2 = _state.value.fromCurrencyAmount2 + number
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    override fun onCleared() {
        super.onCleared()
        jobTo.cancel()
    }
}