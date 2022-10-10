package com.v2.sample.clean.feature.usecase.business

import com.v2.sample.clean.domain.Pokemon

interface UseCaseRepository {
    fun doFetch(name: String?): Pokemon?
}