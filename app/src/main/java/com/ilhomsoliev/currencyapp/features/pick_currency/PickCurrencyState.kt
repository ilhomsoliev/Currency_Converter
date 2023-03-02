package com.ilhomsoliev.currencyapp.features.pick_currency

import com.ilhomsoliev.currencyapp.core.Constants
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity

data class PickCurrencyState(
    val searchValue: String = "",
    val currencies: List<CurrencyEntity> = listOf(),
    val typeSend: String = Constants.TYPE_FROM
)