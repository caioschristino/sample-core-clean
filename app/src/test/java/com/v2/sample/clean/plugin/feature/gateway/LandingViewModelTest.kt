package com.v2.sample.clean.plugin.feature.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModelTest
import com.v2.sample.clean.DataFactory
import com.v2.sample.clean.feature.landing.business.LandingRepository
import com.v2.sample.clean.feature.landing.business.LandingUseCase
import com.v2.sample.clean.feature.landing.domain.Landing
import com.v2.sample.clean.feature.landing.gateway.LandingGatewayInjector
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.sample.clean.plugin.feature.landing.gateway.LandingViewModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class LandingViewModelTest : BaseViewModelTest<LandingViewModel>() {
    private lateinit var repository: LandingRepository

    @Before
    override fun setup() {
        super.setup()
    }

    @After
    override fun teardown() {
        super.teardown()
    }

    @Test
    fun `when fetch succeeds, assert callbacks`() {
        val result = arrangeFetch()
        doGet()
        assertViewStateSuccess(result)
    }

    @Test
    fun `when fetch throws exception, assert callbacks`() {
        val exception = RuntimeException()
        whenever(repository.doFetch()).thenThrow(exception)
        doGet()
        assertViewStateError(exception)
    }

    override fun setupViewModel() {
        repository = mock()
        LandingGatewayInjector.self = object : LandingGatewayInjector {
            override val doFetch: LandingUseCase
                get() = LandingUseCase(repository)
        }
        viewModel = spy(LandingViewModel())
    }

    private fun doGet() {
        runBlocking { viewModel?.doFetch(DataFactory.randomUuid()) }
    }

    private fun arrangeFetch(): Landing {
        val result = mock<Landing>()
        whenever(repository.doFetch()).thenReturn(result)
        return result
    }
}