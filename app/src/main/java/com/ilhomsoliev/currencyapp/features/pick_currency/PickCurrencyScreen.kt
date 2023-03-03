package com.ilhomsoliev.currencyapp.features.pick_currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.currencyapp.app.theme.Arsenic
import com.ilhomsoliev.currencyapp.app.theme.Arsenic32
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun PickCurrencyScreen(
    state: PickCurrencyState,
    onEvent: (PickCurrencyEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Arsenic32)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconButton(onClick = {
                onEvent(PickCurrencyEvent.OnBackPress)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Currencies",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        TextField(
            value = state.searchValue,
            onValueChange = { value ->
                onEvent(PickCurrencyEvent.ChangeSearchValue(value))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .clip(RoundedCornerShape(12.dp)),
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            placeholder = { Text(text = "Search", color = Color.White) },
            singleLine = true,
            shape = RectangleShape,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                leadingIconColor = Color.White,
                trailingIconColor = Color.White,
                backgroundColor = Color(0xFF4D4D4D),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        LazyColumn() {
            val searchedText = state.searchValue
            val filteredItems = if (searchedText.isEmpty()) {
                state.currencies
            } else {
                val resultList = ArrayList<CurrencyEntity>()
                for (item in state.currencies) {
                    if (item.name.lowercase(Locale.getDefault())
                            .contains(searchedText.lowercase(Locale.getDefault())) ||
                        item.initials.lowercase(Locale.getDefault())
                            .contains(searchedText.lowercase(Locale.getDefault()))
                    ) {
                        resultList.add(item)
                    }
                }
                resultList
            }
            items(filteredItems.sortedBy { it.editedAt }.reversed()) {
                CurrencyItem(currencyName = it.name, currencyInitials = it.initials, onClick = {
                    onEvent(
                        PickCurrencyEvent.OnItemClick(it.id!!)
                    )
                }, currencyIcon = it.countryFlagLink)
            }
        }
    }
}