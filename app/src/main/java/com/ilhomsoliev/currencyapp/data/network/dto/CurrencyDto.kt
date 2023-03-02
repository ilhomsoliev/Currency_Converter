package com.ilhomsoliev.currencyapp.data.network.dto

import com.ilhomsoliev.currencyapp.domain.model.Currency

data class CurrencyDto(
    val amount: Double,
    val error: Int,
    val error_message: String
)

fun CurrencyDto.toCurrency(from: String, to: String) = Currency(
    from = from,
    to = to,
    rate = amount,
)