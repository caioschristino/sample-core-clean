package com.v2.sample.clean.feature.chainusecase.business

import com.v2.sample.clean.feature.chainusecase.domain.Landing

interface ChainUseCaseRepository {
    fun doFetch(): Landing?
}