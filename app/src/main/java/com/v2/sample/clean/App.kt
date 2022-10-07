package com.v2.sample.clean

import android.app.Application
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.chainusecase.business.ChainUseCaseRepository
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseGatewayInjector
import com.v2.sample.clean.feature.chainusecase.view.ChainUseCaseFragment
import com.v2.sample.clean.feature.chainusecase.view.ChainUseCaseViewInjector
import com.v2.sample.clean.plugin.feature.landing.LandingRepositoryImplChain
import com.v2.sample.clean.plugin.feature.landing.gateway.ControllerFactoryImpl

class App : Application() {
    private val baseApiUrl = "https://pokeapi.co/api/v2/"

    override fun onCreate() {
        super.onCreate()
        doGatewayInjector()
    }
    private fun doGatewayInjector() {
        LandingGatewayInjector.self = object : ChainUseCaseGatewayInjector {
            override val doFetch: ChainUseCase
                get() = ChainUseCase(injectaCacheRepository())
        }

        LandingViewInjector.self = object : ChainUseCaseViewInjector {
            override val controllerFactory: ControllerFactory<ChainUseCaseFragment, ChainUseCaseController>
                get() = ControllerFactoryImpl()
        }
    }

    private fun injectaCacheRepository(): ChainUseCaseRepository {
        return LandingRepositoryImplChain(baseApiUrl)
    }
}