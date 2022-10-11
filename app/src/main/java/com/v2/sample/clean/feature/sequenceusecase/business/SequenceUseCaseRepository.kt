package com.v2.sample.clean.feature.sequenceusecase.business

import com.v2.sample.clean.feature.sequenceusecase.domain.Pokemon

interface SequenceUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getIvysaur(): Pokemon?
    fun getVenusaur(): Pokemon?
}