package com.v2.sample.clean.plugin.feature.landing.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModel
import com.v2.sample.clean.feature.landing.business.LandingUseCase
import com.v2.sample.clean.feature.landing.gateway.LandingController
import com.v2.sample.clean.feature.landing.gateway.LandingGatewayInjector.Companion.self as injector

class LandingViewModel : BaseViewModel(), LandingController {
    private val fetcher by lazy { injectLanding() }

    private fun injectLanding(): LandingUseCase {
        return injector.doFetch
    }

    override fun doFetch(channelName: String) {
        dispatchUseCase(null, fetcher) {
            postValue(channelName, it)
        }
    }
}