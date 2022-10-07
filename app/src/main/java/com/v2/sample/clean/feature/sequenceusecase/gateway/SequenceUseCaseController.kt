package com.v2.sample.clean.feature.sequenceusecase.gateway

import br.com.clean.core.gateway.mvvm.Controller

interface SequenceUseCaseController : Controller {
    fun doFetch(channelName: String)
}