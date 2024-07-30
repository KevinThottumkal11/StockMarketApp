package com.plcoding.stockmarketapp.di

import com.plcoding.stockmarketapp.data.csv.CSVParser
import com.plcoding.stockmarketapp.data.csv.CompanyListingsParser
import com.plcoding.stockmarketapp.data.csv.IntradayInfoParser
import com.plcoding.stockmarketapp.data.repository.StockRepositoryImplement
import com.plcoding.stockmarketapp.domain.model.CompanyListing
import com.plcoding.stockmarketapp.domain.model.IntradayInfo
import com.plcoding.stockmarketapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // For dagger hilt to inject the CompanyListingsParser dependency into the Stock Repository
    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser (
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    // For dagger hilt to inject the IntradayInfoParser dependency into the Stock Repository
    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser (
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

    // for the StockRepository dependency injection into theCompanyListingsViewModel
    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImplement: StockRepositoryImplement
    ): StockRepository
}