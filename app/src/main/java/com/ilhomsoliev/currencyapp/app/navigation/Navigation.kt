package com.ilhomsoliev.currencyapp.app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ilhomsoliev.currencyapp.core.Constants
import com.ilhomsoliev.currencyapp.core.Screens
import com.ilhomsoliev.currencyapp.features.main.MainEvent
import com.ilhomsoliev.currencyapp.features.main.MainScreen
import com.ilhomsoliev.currencyapp.features.main.MainScreenViewModel
import com.ilhomsoliev.currencyapp.features.pick_currency.PickCurrencyEvent
import com.ilhomsoliev.currencyapp.features.pick_currency.PickCurrencyScreen
import com.ilhomsoliev.currencyapp.features.pick_currency.PickCurrencyViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(route = Screens.MainScreen.route) {
            val viewModel = hiltViewModel<MainScreenViewModel>()
            val state by viewModel.state.collectAsState()
            MainScreen(state, onEvent = { event: MainEvent ->
                when (event) {
                    is MainEvent.OpenPickCurrency -> {
                        navController.navigate(
                            Screens.PickCurrencyScreen.route.replace(
                                "{${Constants.TYPE_ID}}",
                                event.type
                            )
                        )
                    }
                    else -> {
                        viewModel.onEvent(event)
                    }
                }
            })
        }
        composable(
            route = Screens.PickCurrencyScreen.route,
            arguments = listOf(navArgument(Constants.TYPE_ID) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<PickCurrencyViewModel>()
            PickCurrencyScreen(viewModel.state.collectAsState().value, onEvent = {
                when (it) {
                    is PickCurrencyEvent.OnItemClick -> {
                        viewModel.viewModelScope.launch {
                            when (navBackStackEntry.arguments?.getString(Constants.TYPE_ID)
                                ?: Constants.TYPE_FROM) {
                                Constants.TYPE_FROM -> {
                                    viewModel.dataStoreManager.updateFromCurrency(it.id)
                                }
                                Constants.TYPE_TO -> {
                                    viewModel.dataStoreManager.updateToCurrency(it.id)
                                }
                            }
                            navController.popBackStack()
                        }
                    }
                    is PickCurrencyEvent.OnBackPress -> {
                        navController.popBackStack()
                    }
                    else -> {
                        viewModel.onEvent(it)
                    }
                }
            })
        }
    }
}