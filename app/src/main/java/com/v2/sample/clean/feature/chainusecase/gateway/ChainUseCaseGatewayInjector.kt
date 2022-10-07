package com.v2.sample.clean.feature.chainusecase.gateway

import com.v2.sample.clean.feature.chainusecase.business.FirstUseCase
import com.v2.sample.clean.feature.chainusecase.business.SecondUseCase

interface ChainUseCaseGatewayInjector {
    companion object {
        lateinit var self: ChainUseCaseGatewayInjector
    }

    val doFirst: FirstUseCase
    val doSecond: SecondUseCase
}