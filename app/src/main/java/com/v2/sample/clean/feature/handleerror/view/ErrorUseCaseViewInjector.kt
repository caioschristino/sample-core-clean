package com.v2.sample.clean.feature.handleerror.view

import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.handleerror.gateway.ErrorUseCaseController

interface ErrorUseCaseViewInjector {
    companion object {
        lateinit var self: ErrorUseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<ErrorUseCaseFragment, ErrorUseCaseController>
}