package com.v2.sample.clean.feature.usecase.view

import android.view.View
import br.com.clean.core.view.ui.BaseFragment
import com.v2.sample.clean.R
import com.v2.sample.clean.feature.usecase.gateway.UseCaseController
import com.v2.sample.clean.feature.usecase.view.UseCaseViewInjector.Companion.self as injector

class UseCaseFragment : BaseFragment<UseCaseController>() {
    companion object {
        fun newInstance() = UseCaseFragment()

        const val useCaseChannel = "useCaseChannel"
    }

    override fun channelName(): String = useCaseChannel

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

    override fun setupController(): UseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(useCaseChannel)
    }
}