package com.v2.sample.clean.feature.chainusecase.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.feature.chainusecase.domain.ChainPokemon

class GETBulbasaurUseCase(
    private val repo: ChainUseCaseRepository
) : UseCase<Void, ChainPokemon>() {

    override fun execute(param: Void?): Output<ChainPokemon> {
        val landing = ChainPokemon()
        landing.results.add(repo.getBulbasaur())

        return ValueOutput(landing)
    }
}