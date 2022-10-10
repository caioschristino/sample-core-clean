package com.v2.sample.clean.plugin.feature.usecase.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModel
import com.v2.sample.clean.feature.usecase.business.GETBulbasaurUseCase
import com.v2.sample.clean.feature.usecase.gateway.UseCaseController
import com.v2.sample.clean.feature.usecase.gateway.UseCaseGatewayInjector.Companion.self as injector

class UseCaseViewModel : BaseViewModel(), UseCaseController {
    private val getBulbasaur by lazy { injectBulbasaurUseCase() }

    private fun injectBulbasaurUseCase(): GETBulbasaurUseCase {
        return injector.getBulbasaur
    }

    override fun doFetch(channelName: String) {
        dispatchUseCase(POKEMON_NAME, getBulbasaur) { postValue(channelName, it) }
    }

    companion object {
        private const val POKEMON_NAME = "bulbasaur"
    }
}