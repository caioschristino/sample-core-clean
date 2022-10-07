package com.v2.sample.clean.feature.chainusecase.view

import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseController

interface ChainUseCaseViewInjector {
    companion object {
        lateinit var self: ChainUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<ChainUseCaseFragment, ChainUseCaseController>
}