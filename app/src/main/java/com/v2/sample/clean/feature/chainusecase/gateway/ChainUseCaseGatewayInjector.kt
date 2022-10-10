package com.v2.sample.clean.feature.chainusecase.gateway

import com.v2.sample.clean.feature.chainusecase.business.GETBulbasaurUseCase
import com.v2.sample.clean.feature.chainusecase.business.GETVenusaurUseCase

interface ChainUseCaseGatewayInjector {
    companion object {
        lateinit var self: ChainUseCaseGatewayInjector
    }

    val getBulbasaur: GETBulbasaurUseCase
    val getVenusaur: GETVenusaurUseCase
}