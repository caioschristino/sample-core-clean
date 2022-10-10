package com.v2.sample.clean.feature.sequenceusecase.view

import android.view.View
import br.com.clean.core.view.ui.BaseFragment
import com.v2.sample.clean.R
import com.v2.sample.clean.feature.sequenceusecase.gateway.SequenceUseCaseController
import com.v2.sample.clean.feature.sequenceusecase.view.SequenceUseCaseViewInjector.Companion.self as injector

class SequenceUseCaseFragment : BaseFragment<SequenceUseCaseController>() {
    companion object {
        fun newInstance() = SequenceUseCaseFragment()

        const val sequenceUseCase = "sequenceUseCase"
    }

    override fun channelName(): String = sequenceUseCase

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

    override fun setupController(): SequenceUseCaseController {
        return injector.controllerFactory.create(this)
    }

    private fun fetch() {
        controller.doFetch(sequenceUseCase)
    }
}