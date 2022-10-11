package com.v2.sample.clean.plugin.feature.chainusecase

import com.v2.sample.clean.feature.chainusecase.business.ChainUseCaseRepository
import com.v2.sample.clean.feature.chainusecase.domain.Pokemon
import com.v2.sample.clean.plugin.api.BaseRepository
import com.v2.sample.clean.plugin.api.ChainUseCasePokedexAPI
import com.v2.sample.clean.plugin.api.ChainUseCasePokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class ChainUseCaseRepositoryImpl(url: String) :
    BaseRepository(url), ChainUseCaseRepository {

    override fun getBulbasaur(): Pokemon? {
        return getBodyOrThrow(getService().getBulbasaur())
    }

    override fun getIvysaur(): Pokemon? {
        return getBodyOrThrow(getService().getIvysaur())
    }

    override fun getService(interceptors: List<Interceptor>): ChainUseCasePokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return ChainUseCasePokedexAPIBuilder(baseUrl, list).build()
    }
}