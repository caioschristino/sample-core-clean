package com.v2.sample.clean.feature.sequenceusecase.business

import com.v2.sample.clean.feature.chainusecase.domain.Landing

interface UseCaseRepository {
    fun doFetch(): Landing?
}