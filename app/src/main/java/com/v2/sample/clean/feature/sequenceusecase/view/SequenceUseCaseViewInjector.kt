package com.v2.sample.clean.feature.sequenceusecase.view

import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.sequenceusecase.gateway.SequenceUseCaseController

interface SequenceUseCaseViewInjector {
    companion object {
        lateinit var self: SequenceUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<SequenceUseCaseFragment, SequenceUseCaseController>
}