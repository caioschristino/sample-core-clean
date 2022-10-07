package com.v2.sample.clean.plugin.feature.landing

import com.v2.sample.clean.feature.landing.business.LandingRepository
import com.v2.sample.clean.feature.landing.domain.Landing
import com.v2.sample.clean.plugin.api.LoggedInRepository
import com.v2.sample.clean.plugin.api.PokedexAPI
import com.v2.sample.clean.plugin.api.PokedexAPIBuilder
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

open class LandingRepositoryImpl(url: String) : LoggedInRepository(url, "token"),
    LandingRepository {

    override fun doFetch(): Landing? {
        return getBodyOrThrow(getService().fetch())
    }

    override fun getService(interceptors: List<Interceptor>): PokedexAPI {
        val authInterceptor = getAuthInterceptor()
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val list = mutableListOf(authInterceptor, loggingInterceptor).apply { addAll(interceptors) }
        return PokedexAPIBuilder(baseUrl, list).build()
    }
}