package com.ilhomsoliev.currencyapp.features.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PedalBike
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.toUpperCase
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ilhomsoliev.currencyapp.app.theme.Arsenic
import com.ilhomsoliev.currencyapp.core.Constants
import com.ilhomsoliev.currencyapp.core.Helper.toTimeHoursAndMinutes
import com.ilhomsoliev.currencyapp.features.components.BottomBar
import com.ilhomsoliev.currencyapp.features.components.CalculatorKeyboard
import com.ilhomsoliev.currencyapp.features.components.CurrencyTablet
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = false, block = {
        onEvent(MainEvent.FirstLaunch(context.resources.configuration.locale.country))
    })

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        val (
            fromTablet, calculatorKeyboard, bottomBar
        ) = createRefs()
        Column(modifier = Modifier.constrainAs(fromTablet) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(calculatorKeyboard.top)
            end.linkTo(parent.end)
            height = Dimension.fillToConstraints
        }) {
            CurrencyTablet(
                modifier = Modifier.weight(1f),
                image = state.fromCurrencySymbol,
                currencyIni = state.fromCurrencyIni?.uppercase(Locale.ROOT) ?: "",
                amount = state.fromCurrencyAmount2.ifEmpty { state.fromCurrencyAmount1 }
            ) {
                onEvent(MainEvent.OpenPickCurrency(Constants.TYPE_FROM))
            }
            Divider(color = Arsenic)
            CurrencyTablet(
                modifier = Modifier.weight(1f),
                image = state.toCurrencySymbol,
                currencyIni = state.toCurrencyIni?.uppercase(Locale.ROOT) ?: "",
                amount =
                (if (state.fromCurrencyAmount2.isNotEmpty()) (state.fromCurrencyAmount2.toDouble() * state.exchangeRate)
                else if (state.fromCurrencyAmount1.isNotEmpty()) (state.fromCurrencyAmount1.toDouble() * state.exchangeRate)
                else "0").toString()
            ) {
                onEvent(MainEvent.OpenPickCurrency(Constants.TYPE_TO))
            }
        }
        CalculatorKeyboard(modifier = Modifier.constrainAs(calculatorKeyboard) {
            start.linkTo(parent.start)
            bottom.linkTo(bottomBar.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }, onEvent = {
            onEvent(it)
        })
        BottomBar(
            modifier = Modifier.constrainAs(bottomBar) {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            isLoading = state.isLoading,
            lateUpdate = state.lastUpdateTime?.toTimeHoursAndMinutes() ?: "",
            currencyExchangeRate = "1 ${state.fromCurrencyIni?.uppercase()} = ${state.exchangeRate} ${state.toCurrencyIni?.uppercase()}",
            onRefreshClick = {
                onEvent(MainEvent.Refresh)
            })
    }
}