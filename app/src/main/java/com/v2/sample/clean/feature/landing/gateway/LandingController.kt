package com.v2.sample.clean.feature.landing.gateway

import br.com.clean.core.gateway.mvvm.Controller

interface LandingController : Controller {
    fun doFetch(channelName: String)
}