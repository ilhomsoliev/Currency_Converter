package com.ilhomsoliev.currencyapp.domain.repository

import com.ilhomsoliev.currencyapp.domain.model.Currency

interface CurrencyRepository {
    suspend fun getCurrency(from: String, to: String): String
}