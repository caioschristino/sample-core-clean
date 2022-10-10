package com.v2.sample.clean.feature.usecase.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.domain.Pokemon

class GETBulbasaurUseCase(
    private val repo: UseCaseRepository
) : UseCase<String, Pokemon>() {

    override fun execute(param: String?): Output<Pokemon> {
        val pokemon = repo.doFetch(param)
        return ValueOutput(pokemon)
    }
}