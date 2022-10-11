package com.v2.sample.clean.plugin.feature.handleerror.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModelTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.sample.clean.DataFactory
import com.v2.sample.clean.feature.handleerror.business.ErrorUseCase
import com.v2.sample.clean.feature.handleerror.business.ErrorUseCaseRepository
import com.v2.sample.clean.feature.handleerror.domain.Pokemon
import com.v2.sample.clean.feature.handleerror.gateway.ErrorUseCaseGatewayInjector
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


class ErrorUseCaseViewModelTest : BaseViewModelTest<ErrorUseCaseViewModel>() {
    private lateinit var repository: ErrorUseCaseRepository

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
        val name = DataFactory.randomUuid()
        whenever(repository.doFetch(name)).thenThrow(exception)
        doGet()
        assertViewStateError(exception)
    }

    override fun setupViewModel() {
        repository = mock()
        ErrorUseCaseGatewayInjector.self = object : ErrorUseCaseGatewayInjector {
            override val doError: ErrorUseCase
                get() = ErrorUseCase(repository)
        }
        viewModel = spy(ErrorUseCaseViewModel())
    }

    private fun doGet() {
        runBlocking { viewModel?.doFetch(DataFactory.randomUuid()) }
    }

    private fun arrangeFetch(): Pokemon {
        val result = mock<Pokemon>()
        whenever(repository.doFetch(any())).thenReturn(result)

        return result
    }
}