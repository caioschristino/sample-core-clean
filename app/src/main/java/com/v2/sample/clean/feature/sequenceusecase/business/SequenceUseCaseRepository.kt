package com.v2.sample.clean.feature.sequenceusecase.business

import com.v2.sample.clean.domain.Pokemon

interface SequenceUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getIvysaur(): Pokemon?
    fun getVenusaur(): Pokemon?
}