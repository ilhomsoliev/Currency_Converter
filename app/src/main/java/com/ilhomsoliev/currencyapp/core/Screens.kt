package com.ilhomsoliev.currencyapp.core

sealed class Screens(val route: String) {
    object MainScreen : Screens("HomeScreen")
    object PickCurrencyScreen : Screens("PickCurrencyScreen/{${Constants.TYPE_ID}}")
}