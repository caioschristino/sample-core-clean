package com.v2.sample.clean.feature.usecase.view

import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.usecase.gateway.UseCaseController

interface UseCaseViewInjector {
    companion object {
        lateinit var self: UseCaseViewInjector
    }

    val controllerFactory: ControllerFactory<UseCaseFragment, UseCaseController>
}