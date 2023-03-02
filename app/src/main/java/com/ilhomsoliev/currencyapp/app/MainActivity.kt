package com.ilhomsoliev.currencyapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilhomsoliev.currencyapp.app.navigation.Navigation
import com.ilhomsoliev.currencyapp.app.theme.CurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<CurrencyApplicationViewModel>()
            CurrencyAppTheme {
                Navigation()
            }
        }
    }
}