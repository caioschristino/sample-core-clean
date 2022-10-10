package com.v2.sample.clean.plugin.feature.handleerror.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModel
import com.v2.sample.clean.feature.handleerror.business.ErrorUseCase
import com.v2.sample.clean.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.sample.clean.feature.handleerror.gateway.ErrorUseCaseGatewayInjector.Companion.self as injector

class ErrorUseCaseViewModel : BaseViewModel(), ErrorUseCaseController {
    private val doError by lazy { injectError() }

    private fun injectError(): ErrorUseCase {
        return injector.doError
    }

    override fun doFetch(channelName: String) {
        //null generate error on getPokemon api
        dispatchUseCase(null, doError) { postValue(channelName, it) }
    }
}