package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.currencyapp.R
import com.ilhomsoliev.currencyapp.app.theme.Bistre

@Composable
fun CurrencyTablet(
    modifier: Modifier = Modifier,
    image: Int,
    currencyIni: String,
    amount: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .background(Bistre),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (image != 0) {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape),
                        painter = painterResource(
                            id = image
                        ),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                    Text(text = currencyIni, color = Color.White)
                }
            }
            Text(
                modifier = Modifier.padding(end = 4.dp),
                text = amount,
                fontSize = 42.sp,
                color = Color.White
            )
        }
    }
}
