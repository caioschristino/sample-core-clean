package com.v2.sample.clean.plugin.feature.sequenceusecase

import com.v2.sample.clean.domain.Pokemon
import com.v2.sample.clean.feature.sequenceusecase.business.SequenceUseCaseRepository
import com.v2.sample.clean.plugin.api.LoggedInRepository
import com.v2.sample.clean.plugin.api.PokedexAPI
import com.v2.sample.clean.plugin.api.PokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class SequenceUseCaseRepositoryImpl(url: String) :
    LoggedInRepository(url, "token"), SequenceUseCaseRepository {

    override fun getBulbasaur(): Pokemon? {
        return getBodyOrThrow(getService().getBulbasaur())
    }

    override fun getIvysaur(): Pokemon? {
        return getBodyOrThrow(getService().getIvysaur())
    }

    override fun getVenusaur(): Pokemon? {
        return getBodyOrThrow(getService().getVenusaur())
    }

    override fun getService(interceptors: List<Interceptor>): PokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return PokedexAPIBuilder(baseUrl, list).build()
    }
}