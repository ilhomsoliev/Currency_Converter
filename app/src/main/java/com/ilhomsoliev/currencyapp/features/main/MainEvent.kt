package com.ilhomsoliev.currencyapp.features.main


sealed class MainEvent {
    data class OpenPickCurrency(val type:String) : MainEvent()
    object Refresh : MainEvent()
    data class NumberClick(val number: Char) : MainEvent()
    object ClearAll : MainEvent()
    object ReverseCurrencies : MainEvent()
    object StepBack : MainEvent()
    data class FirstLaunch(val country: String) : MainEvent()
    data class SymbolClick(val symbol: Char) : MainEvent()
    data class Number(val number: Int): MainEvent()
    object Clear: MainEvent()
    object Delete: MainEvent()
    data class Operation(val operation: CalculatorOperation): MainEvent()
    object Calculate: MainEvent()
    object Decimal: MainEvent()

}