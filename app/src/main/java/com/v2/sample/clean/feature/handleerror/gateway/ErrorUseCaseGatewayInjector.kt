package com.v2.sample.clean.feature.landing.gateway

import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseGatewayInjector

interface ErrorUseCaseGatewayInjector {
    companion object {
        lateinit var self: ChainUseCaseGatewayInjector
    }

    val doFetch: ChainUseCase
}