package com.ilhomsoliev.currencyapp.features.pick_currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.currencyapp.core.DataStoreManager
import com.ilhomsoliev.currencyapp.data.local.dao.CurrenciesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PickCurrencyViewModel @Inject constructor(
    val dataStoreManager: DataStoreManager,
    private val currenciesDao: CurrenciesDao,
) : ViewModel() {
    private val _state = MutableStateFlow(PickCurrencyState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        PickCurrencyState()
    )

    init {
        currenciesDao.getCurrencies().onEach { list ->
            _state.update {
                it.copy(
                    searchValue = _state.value.searchValue,
                    currencies = list
                )
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: PickCurrencyEvent) {
        when (event) {
            is PickCurrencyEvent.ChangeSearchValue -> {
                _state.update {
                    it.copy(
                        searchValue = event.value
                    )
                }
            }
            is PickCurrencyEvent.ChangeTypeSend -> {
                _state.update {
                    it.copy(
                        typeSend = event.type
                    )
                }
            }
            else -> return
        }
    }


}