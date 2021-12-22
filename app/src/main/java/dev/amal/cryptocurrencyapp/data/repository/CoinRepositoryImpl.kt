package dev.amal.cryptocurrencyapp.data.repository

import dev.amal.cryptocurrencyapp.data.remote.CoinPaprikaApi
import dev.amal.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import dev.amal.cryptocurrencyapp.data.remote.dto.CoinDto
import dev.amal.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> =
        api.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto =
        api.getCoinById(coinId)

}