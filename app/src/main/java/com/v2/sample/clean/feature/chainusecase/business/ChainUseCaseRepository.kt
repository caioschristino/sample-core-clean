package com.v2.sample.clean.feature.chainusecase.business

import com.v2.sample.clean.feature.chainusecase.domain.Pokemon


interface ChainUseCaseRepository {
    fun getBulbasaur(): Pokemon?
    fun getIvysaur(): Pokemon?
}