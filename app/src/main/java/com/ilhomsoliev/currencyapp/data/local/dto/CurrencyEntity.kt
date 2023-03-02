package com.ilhomsoliev.currencyapp.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CurrencyEntity.TABLE_NAME)
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int? = null,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_INITIALS) val initials: String,
    @ColumnInfo(name = COLUMN_EDITED_AT) val editedAt: Long,
    @ColumnInfo(name = COLUMN_COUNTRY_FLAG_LINK) val countryFlagLink: Int,
) {
    companion object {
        const val TABLE_NAME = "currency_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_INITIALS = "initials"
        const val COLUMN_EDITED_AT = "edited_at"
        const val COLUMN_COUNTRY_FLAG_LINK = "country_flag_link"
    }
}