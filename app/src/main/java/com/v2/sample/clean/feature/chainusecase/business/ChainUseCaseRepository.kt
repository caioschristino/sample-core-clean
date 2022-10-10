package com.v2.sample.clean.feature.chainusecase.business

import com.v2.sample.clean.domain.Pokemon

interface ChainUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getVenusaur(): Pokemon?
}