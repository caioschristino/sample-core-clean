package com.v2.sample.clean.plugin.feature.handleerror.gateway


import androidx.lifecycle.ViewModelProvider
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.handleerror.gateway.ErrorUseCaseController
import com.v2.sample.clean.feature.handleerror.view.ErrorUseCaseFragment

class ErrorUseCaseControllerFactoryImpl :
    ControllerFactory<ErrorUseCaseFragment, ErrorUseCaseController> {
    override fun create(context: ErrorUseCaseFragment): ErrorUseCaseController {
        return ViewModelProvider(context)[ErrorUseCaseViewModel::class.java]
    }
}