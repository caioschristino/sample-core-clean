package com.v2.sample.clean.feature.sequenceusecase.gateway


import com.v2.sample.clean.feature.sequenceusecase.business.GETBulbasaurUseCase
import com.v2.sample.clean.feature.sequenceusecase.business.GETIvysaurUseCase
import com.v2.sample.clean.feature.sequenceusecase.business.GETVenusaurUseCase

interface SequenceUseCaseGatewayInjector {
    companion object {
        lateinit var self: SequenceUseCaseGatewayInjector
    }

    val getBulbasaur: GETBulbasaurUseCase
    val getVenusaur: GETVenusaurUseCase
    val getIvysaur: GETIvysaurUseCase
}