package com.ilhomsoliev.currencyapp.features.pick_currency

sealed class PickCurrencyEvent {
    object OnBackPress : PickCurrencyEvent()
    data class OnItemClick(val id: Int) : PickCurrencyEvent()
    data class ChangeSearchValue(val value: String) : PickCurrencyEvent()
    data class ChangeTypeSend(val type:String) : PickCurrencyEvent()
}