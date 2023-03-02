package com.ilhomsoliev.currencyapp.di

import android.content.Context
import androidx.room.Room
import com.ilhomsoliev.currencyapp.core.DataStoreManager
import com.ilhomsoliev.currencyapp.data.local.CurrenciesDatabase
import com.ilhomsoliev.currencyapp.data.local.dao.CurrenciesDao
import com.ilhomsoliev.currencyapp.data.network.CurrencyApi
import com.ilhomsoliev.currencyapp.data.network.dto.CurrencyDto
import com.ilhomsoliev.currencyapp.data.network.repository.CurrencyRepositoryImpl
import com.ilhomsoliev.currencyapp.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCurrencyApi(): CurrencyApi {
        return Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net")
            .addConverterFactory(ScalarsConverterFactory.create())
            //.addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
            .create(CurrencyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCurrencyRepository(
        api: CurrencyApi
    ): CurrencyRepository =
        CurrencyRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CurrenciesDatabase {
        return Room.databaseBuilder(context, CurrenciesDatabase::class.java, "currency_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(appDatabase: CurrenciesDatabase): CurrenciesDao {
        return appDatabase.currencyDao()
    }

    @Singleton
    @Provides
    fun provideSessionManager(
        @ApplicationContext context: Context
    ) = DataStoreManager(context)
}