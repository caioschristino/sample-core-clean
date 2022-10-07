package com.v2.sample.clean.feature.landing.business

import com.v2.sample.clean.feature.chainusecase.domain.Landing

interface ErrorRepository {
    fun doFetch(): Landing?
}