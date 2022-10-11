package com.v2.sample.clean.feature.chainusecase.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.feature.chainusecase.domain.ChainPokemon

class GETVenusaurUseCase(
    private val repo: ChainUseCaseRepository
) : UseCase<ChainPokemon, ChainPokemon>() {

    override fun execute(param: ChainPokemon?): Output<ChainPokemon> {
        param?.results?.add(repo.getIvysaur())
        return ValueOutput(param)
    }
}