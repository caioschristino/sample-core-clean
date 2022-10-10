package com.v2.sample.clean.plugin.feature.sequenceusecase.gateway

import androidx.lifecycle.ViewModelProvider
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.sequenceusecase.gateway.SequenceUseCaseController
import com.v2.sample.clean.feature.sequenceusecase.view.SequenceUseCaseFragment

class SequenceUseCaseControllerFactoryImpl :
    ControllerFactory<SequenceUseCaseFragment, SequenceUseCaseController> {
    override fun create(context: SequenceUseCaseFragment): SequenceUseCaseController {
        return ViewModelProvider(context)[SequenceUseCaseViewModel::class.java]
    }
}