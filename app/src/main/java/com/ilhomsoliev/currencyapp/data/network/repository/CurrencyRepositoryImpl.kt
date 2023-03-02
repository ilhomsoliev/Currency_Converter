package com.ilhomsoliev.currencyapp.data.network.repository

import com.ilhomsoliev.currencyapp.data.network.CurrencyApi
import com.ilhomsoliev.currencyapp.data.network.dto.toCurrency
import com.ilhomsoliev.currencyapp.domain.model.Currency
import com.ilhomsoliev.currencyapp.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private val api: CurrencyApi
) : CurrencyRepository {
    override suspend fun getCurrency(from: String, to: String): String =
        api.getCurrency(from, to)//.toCurrency(from, to)
}