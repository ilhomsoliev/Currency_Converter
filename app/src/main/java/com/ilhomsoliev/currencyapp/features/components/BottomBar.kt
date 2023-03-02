package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Downloading
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.currencyapp.app.theme.MediumGray

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    lateUpdate: String,
    currencyExchangeRate: String,
    onRefreshClick: () -> Unit,
    isLoading: Boolean,
) {
    Row(
        modifier = modifier.background(MediumGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            onRefreshClick()
        }) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.White)
            } else
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null, tint = Color.White
                )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = lateUpdate, color = Color.Green)
            Text(text = currencyExchangeRate, color = Color.Gray)
        }
        IconButton(onClick = {

        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}