package com.ilhomsoliev.currencyapp.domain.use_cases

import android.util.Log
import com.ilhomsoliev.currencyapp.core.Helper
import com.ilhomsoliev.currencyapp.core.Resource
import com.ilhomsoliev.currencyapp.domain.model.Currency
import com.ilhomsoliev.currencyapp.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    operator fun invoke(from: String, to: String): Flow<Resource<Double>> = flow {
        try {
            emit(Resource.Loading<Double>())
            val response = currencyRepository.getCurrency(from = from, to = to)
            emit(Resource.Success<Double>(Helper.getExchangeRateFromResponse(response)))
        } catch (e: HttpException) {
            emit(
                Resource.Error<Double>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<Double>("Couldn't reach server. Check your internet connection."))
        }
    }
}