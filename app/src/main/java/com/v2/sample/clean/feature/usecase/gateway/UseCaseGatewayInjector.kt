package com.v2.sample.clean.feature.usecase.gateway

import com.v2.sample.clean.feature.usecase.business.UnitUseCase


interface UseCaseGatewayInjector {
    companion object {
        lateinit var self: UseCaseGatewayInjector
    }

    val doUseCase: UnitUseCase
}