package com.v2.sample.clean.feature.chainusecase.domain

data class Landing(
    val count: Int,
    val next: String,
    var results: MutableList<Pokemon>)