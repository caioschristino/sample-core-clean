package com.v2.sample.clean.feature.chainusecase.gateway

import br.com.clean.core.gateway.mvvm.Controller

interface ChainUseCaseController : Controller {
    fun doFetch(channelName: String)
}