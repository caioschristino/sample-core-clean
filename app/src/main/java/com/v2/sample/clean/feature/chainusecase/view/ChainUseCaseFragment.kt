package com.v2.sample.clean.feature.chainusecase.view

import android.view.View
import br.com.clean.core.view.ui.BaseFragment
import com.v2.sample.clean.R
import com.v2.sample.clean.feature.chainusecase.gateway.ChainUseCaseController
import com.v2.sample.clean.feature.chainusecase.view.ChainUseCaseViewInjector.Companion.self as injector

class ChainUseCaseFragment : BaseFragment<ChainUseCaseController>() {
    companion object {
        fun newInstance() = ChainUseCaseFragment()

        const val landingChannel = "landingChannel"
    }

    override fun channelName(): String = landingChannel

    override fun getLayout(): Int = R.layout.fragment_main

    override fun setupViews(view: View) {

    }

    override fun onStart() {
        super.onStart()
        fetch()
    }

    override fun handleSuccess(value: Any?) {
        value.toString()
    }

    override fun setupController(): ChainUseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(landingChannel)
    }
}