package com.v2.sample.clean.feature.landing.gateway

import com.v2.sample.clean.feature.landing.business.LandingUseCase

interface LandingGatewayInjector {
    companion object {
        lateinit var self: LandingGatewayInjector
    }

    val doFetch: LandingUseCase
}