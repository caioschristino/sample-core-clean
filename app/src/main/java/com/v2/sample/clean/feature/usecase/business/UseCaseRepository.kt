package com.v2.sample.clean.feature.usecase.business

import com.v2.sample.clean.feature.chainusecase.domain.Landing

interface UseCaseRepository {
    fun doFetch(): Landing?
}