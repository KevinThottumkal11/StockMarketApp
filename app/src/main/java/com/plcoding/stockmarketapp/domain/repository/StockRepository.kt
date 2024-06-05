package com.plcoding.stockmarketapp.domain.repository

import com.plcoding.stockmarketapp.domain.model.CompanyInfo
import com.plcoding.stockmarketapp.domain.model.CompanyListing
import com.plcoding.stockmarketapp.domain.model.IntradayInfo
import com.plcoding.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> // domain layer should not access the data layer. Therefore, do not use CompanyListingEntity

    suspend fun getIntrdayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompnayInfo(
        symbol: String
    ): Resource<CompanyInfo>

}