package com.v2.sample.clean

import android.app.Application
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.plugin.feature.landing.LandingRepositoryImpl
import com.v2.sample.clean.plugin.feature.landing.gateway.ControllerFactoryImpl
import com.v2.sample.clean.feature.landing.business.LandingRepository
import com.v2.sample.clean.feature.landing.business.LandingUseCase
import com.v2.sample.clean.feature.landing.gateway.LandingController
import com.v2.sample.clean.feature.landing.gateway.LandingGatewayInjector
import com.v2.sample.clean.feature.landing.view.LandingFragment
import com.v2.sample.clean.feature.landing.view.LandingViewInjector

class App : Application() {
    private val baseApiUrl = "https://pokeapi.co/api/v2/"

    override fun onCreate() {
        super.onCreate()

        LandingGatewayInjector.self = object : LandingGatewayInjector {
            override val doFetch: LandingUseCase
                get() = LandingUseCase(injectaCacheRepository())
        }

        LandingViewInjector.self = object : LandingViewInjector {
            override val controllerFactory: ControllerFactory<LandingFragment, LandingController>
                get() = ControllerFactoryImpl()
        }
    }

    private fun injectaCacheRepository(): LandingRepository {
        return LandingRepositoryImpl(baseApiUrl)
    }
}