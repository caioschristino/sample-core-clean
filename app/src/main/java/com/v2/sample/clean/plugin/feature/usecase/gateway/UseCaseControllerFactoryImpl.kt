package com.v2.sample.clean.plugin.feature.usecase.gateway

import androidx.lifecycle.ViewModelProvider
import br.com.clean.core.gateway.mvvm.ControllerFactory
import com.v2.sample.clean.feature.usecase.gateway.UseCaseController
import com.v2.sample.clean.feature.usecase.view.UseCaseFragment

class UseCaseControllerFactoryImpl : ControllerFactory<UseCaseFragment, UseCaseController> {
    override fun create(context: UseCaseFragment): UseCaseController {
        return ViewModelProvider(context)[UseCaseViewModel::class.java]
    }
}