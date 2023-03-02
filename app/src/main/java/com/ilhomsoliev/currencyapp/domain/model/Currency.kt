package com.ilhomsoliev.currencyapp.domain.model
data class Currency(
    val from: String,
    val to: String,
    val rate: Double = 0.0,
){

}

