package com.v2.sample.clean.plugin.feature.landing.gateway

import androidx.lifecycle.ViewModelProvider
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.landing.gateway.LandingController
import com.v2.sample.clean.feature.landing.view.LandingFragment

class ControllerFactoryImpl : ControllerFactory<LandingFragment, LandingController> {
    override fun create(context: LandingFragment): LandingController {
        return ViewModelProvider(context)[LandingViewModel::class.java]
    }
}