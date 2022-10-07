package com.v2.sample.clean.feature.usecase.domain

import com.v2.sample.clean.feature.chainusecase.domain.Pokemon

data class Landing(
    val count: Int,
    val next: String,
    var results: MutableList<Pokemon>)