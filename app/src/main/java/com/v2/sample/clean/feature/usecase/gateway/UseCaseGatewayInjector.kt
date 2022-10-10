package com.v2.sample.clean.feature.usecase.gateway

import com.v2.sample.clean.feature.usecase.business.GETBulbasaurUseCase

interface UseCaseGatewayInjector {
    companion object {
        lateinit var self: UseCaseGatewayInjector
    }

    val getBulbasaur: GETBulbasaurUseCase
}