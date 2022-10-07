package com.v2.sample.clean.feature.usecase.gateway

import br.com.clean.core.gateway.mvvm.Controller

interface UseCaseController : Controller {
    fun doFetch(channelName: String)
}