package com.ilhomsoliev.currencyapp.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.currencyapp.app.theme.Arsenic
import com.ilhomsoliev.currencyapp.app.theme.Arsenic32
import com.ilhomsoliev.currencyapp.app.theme.MediumGray

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    lateUpdate: String,
    currencyExchangeRate: String,
    onRefreshClick: () -> Unit,
    onPasteClick: (String) -> Unit,
    textToCopy: String,
    isLoading: Boolean,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val isDropDownMenuActive = remember { mutableStateOf(false) }
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    DropdownMenu(
        modifier = Modifier.background(Arsenic),
        offset = DpOffset(screenHeight, screenWidth),
        expanded = isDropDownMenuActive.value,
        onDismissRequest = { isDropDownMenuActive.value = false }
    ) {
        DropdownMenuItem(onClick = {
            isDropDownMenuActive.value = false
        }) {
            IconWithText(icon = Icons.Default.ContentCopy, "Copy", onClick = {
                clipboardManager.setText(AnnotatedString((textToCopy)))
            })
        }
        DropdownMenuItem(onClick = {
            clipboardManager.getText()?.text?.let {
                onPasteClick(it)
            }
            isDropDownMenuActive.value = false

        }) {
            IconWithText(icon = Icons.Default.Description, "Paste", onClick = {

            })
        }

        DropdownMenuItem(onClick = {
            isDropDownMenuActive.value = false

        }) {
            IconWithText(icon = Icons.Default.VolumeUp, "Sound", onClick = {

            })
        }
    }

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
            isDropDownMenuActive.value = true

        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = Color.White
            )
        }

    }
}