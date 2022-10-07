package com.v2.sample.clean.feature.landing.view

import android.view.View
import br.com.clean.core.view.ui.BaseFragment
import com.v2.sample.clean.R
import com.v2.sample.clean.feature.landing.domain.Landing
import com.v2.sample.clean.feature.landing.gateway.LandingController
import com.v2.sample.clean.feature.landing.view.LandingViewInjector.Companion.self as injector

class LandingFragment : BaseFragment<LandingController>() {
    companion object {
        fun newInstance() = LandingFragment()

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
        when (value) {
            is Landing? -> loadLanding(value)
        }
    }

    override fun handleError(error: Throwable?) {
        error?.toString()
    }

    override fun setupController(): LandingController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(landingChannel)
    }

    private fun loadLanding(landing: Landing?) {
        landing?.count
    }
}