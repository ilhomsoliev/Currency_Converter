package com.ilhomsoliev.currencyapp.features.pick_currency

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.ilhomsoliev.currencyapp.R
import com.ilhomsoliev.currencyapp.app.theme.MediumGray
import java.util.*

@Composable
fun CurrencyItem(
    currencyName: String,
    currencyInitials: String,
    currencyIcon: Int,
    onClick: () -> Unit,
) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick()
        }
        .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .size(42.dp)
                        .padding(end = 8.dp)
                        .clip(CircleShape),
                    painter = if (currencyIcon == 0) painterResource(id = R.drawable.afghanistan) else painterResource(
                        id = currencyIcon
                    ),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Text(text = currencyName, fontSize = 18.sp, color = Color.White)
            }
            Text(
                modifier = Modifier.padding(end = 6.dp),
                text = currencyInitials.uppercase(Locale.ROOT),
                fontSize = 21.sp,
                color = Color.White,
            )
        }
    }
}