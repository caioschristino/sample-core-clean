package com.v2.sample.clean.plugin.api

import androidx.annotation.VisibleForTesting
import com.v2.sample.clean.domain.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexAPI {
    @GET("pokemon/bulbasaur")
    fun getBulbasaur(): Call<Pokemon>

    @GET("pokemon/venusaur")
    fun getVenusaur(): Call<Pokemon>

    @GET("pokemon/ivysaur")
    fun getIvysaur(): Call<Pokemon>

    @GET("pokemon/name")
    fun getPokemon(@Query("name") name: String?): Call<Pokemon>

    @GET("test")
    @VisibleForTesting
    fun dumbRequest(): Call<Any?>
}