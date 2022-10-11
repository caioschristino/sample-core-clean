package com.v2.sample.clean.feature.handleerror.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.feature.handleerror.domain.Pokemon

class ErrorUseCase(
    private val repo: ErrorUseCaseRepository
) : UseCase<String, Pokemon>() {

    override fun execute(param: String?): Output<Pokemon> {
        val pokemon = repo.doFetch(param)
        return ValueOutput(pokemon)
    }
}