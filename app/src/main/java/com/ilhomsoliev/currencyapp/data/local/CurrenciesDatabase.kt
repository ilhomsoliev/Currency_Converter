package com.ilhomsoliev.currencyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilhomsoliev.currencyapp.data.local.dao.CurrenciesDao
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CurrenciesDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrenciesDao
}