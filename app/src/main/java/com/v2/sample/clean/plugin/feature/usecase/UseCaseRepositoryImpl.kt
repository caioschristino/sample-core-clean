package com.v2.sample.clean.plugin.feature.usecase


import com.v2.sample.clean.domain.Pokemon
import com.v2.sample.clean.feature.usecase.business.UseCaseRepository
import com.v2.sample.clean.plugin.api.LoggedInRepository
import com.v2.sample.clean.plugin.api.PokedexAPI
import com.v2.sample.clean.plugin.api.PokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class UseCaseRepositoryImpl(url: String) : LoggedInRepository(url, "token"),
    UseCaseRepository {

    override fun doFetch(name: String?): Pokemon? {
        return getBodyOrThrow(getService().getPokemon(name))
    }

    override fun getService(interceptors: List<Interceptor>): PokedexAPI {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val list = mutableListOf(loggingInterceptor)
        return PokedexAPIBuilder(baseUrl, list).build()
    }
}