package dev.amal.cryptocurrencyapp.domain.repository

import dev.amal.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import dev.amal.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}