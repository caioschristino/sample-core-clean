package com.v2.sample.clean.plugin.feature.gateway

import br.com.clean.core.business.exception.AuthenticationException
import br.com.clean.core.business.exception.HttpException
import com.v2.sample.clean.DataFactory
import com.v2.sample.clean.plugin.feature.business.LoggedInRepositoryTest
import com.nhaarman.mockitokotlin2.*
import com.v2.sample.clean.feature.landing.domain.Landing
import com.v2.sample.clean.plugin.api.PokedexAPI
import com.v2.sample.clean.plugin.feature.landing.LandingRepositoryImpl
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Test

class LandingRepositoryImplTest : LoggedInRepositoryTest<LandingRepositoryImpl>() {
    private val landing = DataFactory.mockLanding()
    private val emptyLanding = DataFactory.mockEmptyLanding()


    override fun setupRepository(httpUrl: String) {
        repository = spy(LandingRepositoryImpl(httpUrl))
    }

    @Test
    fun `when doFetch assert returns 200, should return Landing with results isNotEmpty`() {
        enqueueEmptyResponse(200)
        stubDoFetch(landing)

        val response = repository.doFetch()

        Assert.assertNotNull(response)
        Assert.assertTrue(response?.results?.isNotEmpty() == true)
        Assert.assertThat(response?.copy(), `is`(landing))
        Assert.assertTrue(response?.results == landing.results)
    }


    @Test
    fun `when doFetch assert returns 200, should return Landing with results isEmpty`() {
        enqueueEmptyResponse(200)
        stubDoFetch(emptyLanding)

        val response = repository.doFetch()

        Assert.assertNotNull(response)
        Assert.assertTrue(response?.results.isNullOrEmpty())
    }

    @Test(expected = HttpException::class)
    fun `when doFetch assert returns 400, then throw HttpException`() {
        enqueueEmptyResponse(400)
        stubDoFetch(landing)

        repository.doFetch()
    }

    @Test(expected = AuthenticationException::class)
    fun `when doFetch assert returns 401, then throw HttpException`() {
        enqueueEmptyResponse(401)
        stubDoFetch(landing)

        repository.doFetch()
    }

    @Test(expected = HttpException::class)
    fun `when doFetch assert returns 500, then throw HttpException`() {
        enqueueEmptyResponse(500)
        stubDoFetch(landing)

        repository.doFetch()
    }

    private fun arrangeService(): PokedexAPI {
        val service = mock<PokedexAPI>()
        whenever(repository.getService())
            .thenReturn(service)

        return service
    }

    private fun stubDoFetch(landing: Landing) =
        whenever(repository.doFetch())
            .thenReturn(landing)
}