package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconWithText(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.padding(horizontal = 0.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
        Text(modifier = Modifier.padding(start = 4.dp), text = text, maxLines = 1, color = Color.White)
    }

}