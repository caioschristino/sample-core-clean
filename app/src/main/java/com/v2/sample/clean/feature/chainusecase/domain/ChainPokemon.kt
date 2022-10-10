package com.v2.sample.clean.feature.chainusecase.domain

import com.v2.sample.clean.domain.Pokemon

data class ChainPokemon(val results: MutableList<Pokemon?> = mutableListOf())