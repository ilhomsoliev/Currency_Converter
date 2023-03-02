package com.ilhomsoliev.currencyapp.app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.currencyapp.core.Helper
import com.ilhomsoliev.currencyapp.data.local.dao.CurrenciesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyApplicationViewModel @Inject constructor(
    private val currenciesDao: CurrenciesDao
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            if (currenciesDao.getCurrenciesAmount() == 0) {
                currenciesDao.insert(Helper.getAllCurrencies())
            }
        }
    }
}