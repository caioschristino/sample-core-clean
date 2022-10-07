package com.v2.sample.clean.feature.landing.view

import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.landing.gateway.LandingController

interface LandingViewInjector {
    companion object {
        lateinit var self: LandingViewInjector
    }

    val controllerFactory: ControllerFactory<LandingFragment, LandingController>
}