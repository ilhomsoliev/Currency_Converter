package com.ilhomsoliev.currencyapp.features.main

data class MainState(
    val fromCurrencyIni: String? = null,
    val fromCurrencySymbol: Int = 0,
    val fromCurrencyAmount1: String = "",
    val fromCurrencyAmount2: String = "",
    val operation: CalculatorOperation? = null,
    val toCurrencyIni: String? = null,
    val toCurrencySymbol: Int = 0,
    val toCurrencyAmount: String = "",
    val exchangeRate: Double = 0.0,
    val error: String? = null,
    val isLoading: Boolean = false,
    val lastUpdateTime: Long? = null,
)