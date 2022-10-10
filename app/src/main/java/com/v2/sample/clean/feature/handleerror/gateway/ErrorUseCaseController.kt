package com.v2.sample.clean.feature.handleerror.gateway

import br.com.clean.core.gateway.mvvm.Controller

interface ErrorUseCaseController : Controller {
    fun doFetch(channelName: String)
}