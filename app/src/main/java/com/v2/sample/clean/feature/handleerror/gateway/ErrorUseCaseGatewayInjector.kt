package com.v2.sample.clean.feature.handleerror.gateway

import com.v2.sample.clean.feature.handleerror.business.ErrorUseCase

interface ErrorUseCaseGatewayInjector {
    companion object {
        lateinit var self: ErrorUseCaseGatewayInjector
    }

    val doError: ErrorUseCase
}