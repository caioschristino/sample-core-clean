package com.v2.sample.clean.feature.handleerror.view

import android.view.View
import br.com.clean.core.view.ui.BaseFragment
import com.v2.sample.clean.R
import com.v2.sample.clean.feature.handleerror.domain.Landing
import com.v2.sample.clean.feature.landing.gateway.ErrorUseCaseController
import com.v2.sample.clean.feature.handleerror.view.ErrorUseCaseViewInjector.Companion.self as injector

class ErrorUseCaseFragment : BaseFragment<ErrorUseCaseController>() {
    companion object {
        fun newInstance() = ErrorUseCaseFragment()

        const val errorUseCaseChannel = "errorUseCaseChannel"
    }

    override fun channelName(): String = errorUseCaseChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {

    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun handleSuccess(value: Any?) {
        when (value) {
            is Landing? -> loadLanding(value)
        }
    }

    override fun handleError(error: Throwable?) {
        error?.toString()
    }

    override fun setupController(): ErrorUseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(errorUseCaseChannel)
    }

    private fun loadLanding(landing: Landing?) {
        landing?.count
    }
}