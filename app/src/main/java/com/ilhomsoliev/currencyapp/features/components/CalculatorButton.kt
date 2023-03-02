package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    symbol: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(color)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {
        if (symbol == null) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.size(38.dp)
                )
            }
        } else {
            Text(
                text = symbol, color = Color.White,
                fontSize = 32.sp
            )
        }
    }

}