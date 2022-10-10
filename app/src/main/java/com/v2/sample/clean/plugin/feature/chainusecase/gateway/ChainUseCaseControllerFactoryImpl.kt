package com.v2.sample.clean.plugin.feature.chainusecase.gateway

import androidx.lifecycle.ViewModelProvider
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.sample.clean.feature.chainusecase.view.ChainUseCaseFragment

class ChainUseCaseControllerFactoryImpl : ControllerFactory<ChainUseCaseFragment, ChainUseCaseController> {
    override fun create(context: ChainUseCaseFragment): ChainUseCaseController {
        return ViewModelProvider(context)[ChainUseCaseViewModel::class.java]
    }
}