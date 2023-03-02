package com.ilhomsoliev.currencyapp.data.local.dao

import androidx.room.*
import com.ilhomsoliev.currencyapp.data.local.dto.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrenciesDao {
    @Query("SELECT * FROM ${CurrencyEntity.TABLE_NAME}")
    fun getCurrencies(): Flow<List<CurrencyEntity>>

    @Query("SELECT COUNT(*) FROM ${CurrencyEntity.TABLE_NAME}")
    suspend fun getCurrenciesAmount(): Int

    @Query("SELECT * FROM ${CurrencyEntity.TABLE_NAME} WHERE id = :currencyId")
    suspend fun getCurrencyById(currencyId: Int): CurrencyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<CurrencyEntity>)

    @Update
    suspend fun update(data: CurrencyEntity)
}