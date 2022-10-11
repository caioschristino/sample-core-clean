package com.v2.sample.clean.plugin.feature.usecase.gateway

import br.com.clean.core.gateway.mvvm.BaseViewModelTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.v2.sample.clean.DataFactory
import com.v2.sample.clean.feature.usecase.business.GETBulbasaurUseCase
import com.v2.sample.clean.feature.usecase.business.UseCaseRepository
import com.v2.sample.clean.feature.usecase.domain.Pokemon
import com.v2.sample.clean.feature.usecase.gateway.UseCaseGatewayInjector
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UseCaseViewModelTest : BaseViewModelTest<UseCaseViewModel>() {
    private lateinit var repository: UseCaseRepository

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
        UseCaseGatewayInjector.self = object : UseCaseGatewayInjector {
            override val getBulbasaur: GETBulbasaurUseCase
                get() = GETBulbasaurUseCase(repository)
        }
        viewModel = spy(UseCaseViewModel())
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