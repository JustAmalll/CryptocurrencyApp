package dev.amal.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.amal.cryptocurrencyapp.common.Constants
import dev.amal.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dev.amal.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import dev.amal.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(
        api: CoinPaprikaApi
    ): CoinRepository = CoinRepositoryImpl(api)

}