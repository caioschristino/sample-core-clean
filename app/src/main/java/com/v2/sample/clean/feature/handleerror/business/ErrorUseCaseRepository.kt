package com.v2.sample.clean.feature.handleerror.business

import com.v2.sample.clean.domain.Pokemon


interface ErrorUseCaseRepository {
    fun doFetch(name: String?): Pokemon?
}