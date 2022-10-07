package com.v2.sample.clean.plugin.api

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

abstract class LoggedInRepository(baseUrl: String, private val token: String) :
    BaseRepository(baseUrl) {

    protected open fun getAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .header("Authorization", "OAuth $token")

            chain.proceed(request.build())
        }
    }

    override fun getService(interceptors: List<Interceptor>): PokedexAPI {
        val authInterceptor = getAuthInterceptor()
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val list = mutableListOf(authInterceptor, loggingInterceptor).apply { addAll(interceptors) }
        return PokedexAPIBuilder(baseUrl, list).build()
    }
}