package com.ilhomsoliev.currencyapp.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("preferences_name")

        val FROM_CURRENCY_KEY = intPreferencesKey("from_currency")
        val TO_CURRENCY_KEY = intPreferencesKey("to_currency")
        val LAST_UPDATE_KEY = longPreferencesKey("last_update")

    }

    suspend fun updateFromCurrency(id: Int) {
        context.dataStore.edit { preferences ->
            preferences[FROM_CURRENCY_KEY] = id
        }
    }

    suspend fun updateLastUpdate(date: Long) {
        context.dataStore.edit { preferences ->
            preferences[LAST_UPDATE_KEY] = date
        }
    }

    suspend fun updateToCurrency(id: Int) {
        context.dataStore.edit { preferences ->
            preferences[TO_CURRENCY_KEY] = id
        }
    }


    val getFromCurrencyId = context.dataStore.data.map {
        it[FROM_CURRENCY_KEY] ?: -1
    }
    val getToCurrencyId = context.dataStore.data.map {
        it[TO_CURRENCY_KEY] ?: -1
    }
    val getLastUpdateTime = context.dataStore.data.map {
        it[LAST_UPDATE_KEY] ?: System.currentTimeMillis()
    }

}