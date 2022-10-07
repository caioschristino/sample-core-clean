package com.v2.sample.clean.feature.landing.business

import com.v2.sample.clean.feature.landing.domain.Landing

interface LandingRepository {
    fun doFetch(): Landing?
}