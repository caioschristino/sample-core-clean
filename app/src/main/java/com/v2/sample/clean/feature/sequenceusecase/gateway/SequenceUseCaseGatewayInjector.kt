package com.v2.sample.clean.feature.sequenceusecase.gateway


import com.v2.sample.clean.feature.sequenceusecase.business.FirstUseCase
import com.v2.sample.clean.feature.sequenceusecase.business.SecondUseCase
import com.v2.sample.clean.feature.sequenceusecase.business.ThirdUseCase

interface SequenceUseCaseGatewayInjector {
    companion object {
        lateinit var self: SequenceUseCaseGatewayInjector
    }

    val doFirst: FirstUseCase
    val doSecond: SecondUseCase
    val doThird: ThirdUseCase
}