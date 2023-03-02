package com.ilhomsoliev.currencyapp.data.network

import com.ilhomsoliev.currencyapp.data.network.dto.CurrencyDto
import retrofit2.http.*

interface CurrencyApi {
    // @Headers("Content-Type: application/json")
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies/{from}/{to}.json")
    suspend fun getCurrency(
        @Path("from") from: String,
        @Path("to") to: String,
    ): String
    //&from=USD&to=EU
}