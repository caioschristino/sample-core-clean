package com.v2.sample.clean.feature.sequenceusecase.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.domain.Pokemon

class GETIvysaurUseCase(
    private val repo: SequenceUseCaseRepository
) : UseCase<Void, Pokemon>() {

    override fun execute(param: Void?): Output<Pokemon> {
        val landing = repo.getIvysaur()
        return ValueOutput(landing)
    }
}