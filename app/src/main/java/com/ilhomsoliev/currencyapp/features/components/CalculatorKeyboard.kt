package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.currencyapp.app.theme.*
import com.ilhomsoliev.currencyapp.features.main.CalculatorOperation
import com.ilhomsoliev.currencyapp.features.main.MainEvent

@Composable
fun CalculatorKeyboard(
    modifier: Modifier = Modifier, onEvent: (MainEvent) -> Unit,
) {
    Column(modifier = modifier.background(Bistre)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorButton(modifier = Modifier
                .padding(end = 1.dp, bottom = 1.dp)
                .aspectRatio(1f)
                .weight(1f),
                color = Arsenic,
                symbol = "C",
                onClick = { onEvent(MainEvent.Clear) })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f),
                color = Arsenic,
                icon = Icons.Default.KeyboardBackspace,
                onClick = { onEvent(MainEvent.Delete) })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), color = Arsenic, icon = Icons.Default.SwapVert, onClick = {
                onEvent(MainEvent.ReverseCurrencies)
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(bottom = 1.dp)
                .weight(1f), color = Orange, symbol = "÷", onClick = {
                onEvent(MainEvent.Operation(CalculatorOperation.Divide))
            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), color = LightGray, symbol = "7", onClick = {
                onEvent(MainEvent.Number(7))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), color = LightGray, symbol = "8", onClick = {
                onEvent(MainEvent.Number(8))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), color = LightGray, symbol = "9", onClick = {
                onEvent(MainEvent.Number(9))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(bottom = 1.dp)
                .weight(1f), color = Orange, symbol = "x", onClick = {
                onEvent(MainEvent.Operation(CalculatorOperation.Multiply))
            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), symbol = "4", onClick = {
                onEvent(MainEvent.Number(4))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), symbol = "5", onClick = {
                onEvent(MainEvent.Number(5))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), symbol = "6", onClick = {
                onEvent(MainEvent.Number(6))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(bottom = 1.dp)
                .weight(1f), color = Orange, symbol = "–", onClick = {
                onEvent(MainEvent.Operation(CalculatorOperation.Subtract))

            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), symbol = "1", onClick = {
                onEvent(MainEvent.Number(1))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)

                .weight(1f), symbol = "2", onClick = {
                onEvent(MainEvent.Number(2))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(end = 1.dp, bottom = 1.dp)
                .weight(1f), symbol = "3", onClick = {
                onEvent(MainEvent.Number(3))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1f)
                .padding(bottom = 1.dp)
                .weight(1f), color = Orange, symbol = "+", onClick = {
                onEvent(MainEvent.Operation(CalculatorOperation.Add))
            })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CalculatorButton(modifier = Modifier
                .aspectRatio(2.25f)
                .padding(end = 1.dp)
                .weight(2f), symbol = "0", onClick = {
                onEvent(MainEvent.Number(0))
            })
            CalculatorButton(modifier = Modifier
                .aspectRatio(1.125f)
                .padding(end = 1.dp)
                .weight(1f), symbol = ".", onClick = {
                onEvent(MainEvent.Decimal)
            })

            CalculatorButton(modifier = Modifier
                .aspectRatio(1.125f)
                .weight(1f), color = Orange, symbol = "=", onClick = {
                onEvent(MainEvent.Calculate)

            })
        }
    }
}