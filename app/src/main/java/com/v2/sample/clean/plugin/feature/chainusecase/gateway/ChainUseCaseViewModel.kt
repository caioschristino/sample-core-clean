package com.v2.sample.clean.plugin.feature.chainusecase.gateway

import br.com.clean.core.business.interactor.ChainedUseCase
import br.com.clean.core.gateway.mvvm.BaseViewModel
import com.v2.sample.clean.feature.chainusecase.business.GETBulbasaurUseCase
import com.v2.sample.clean.feature.chainusecase.business.GETVenusaurUseCase
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseGatewayInjector.Companion.self as injector

class ChainUseCaseViewModel : BaseViewModel(), ChainUseCaseController {
    private val getBulbasaur by lazy { injectBulbasaurUseCase() }
    private val getVenusaur by lazy { injectVenusaurUseCase() }

    private fun injectBulbasaurUseCase(): GETBulbasaurUseCase {
        return injector.getBulbasaur
    }

    private fun injectVenusaurUseCase(): GETVenusaurUseCase {
        return injector.getVenusaur
    }

    override fun doFetch(channelName: String) {
        val chainedUseCase = ChainedUseCase(getBulbasaur, getVenusaur)
        dispatchUseCase(null, chainedUseCase) { postValue(channelName, it) }
    }
}