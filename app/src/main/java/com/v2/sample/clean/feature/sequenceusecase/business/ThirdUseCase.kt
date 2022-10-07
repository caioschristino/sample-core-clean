package com.v2.sample.clean.feature.sequenceusecase.business

import br.com.clean.core.business.dto.Output
import br.com.clean.core.business.dto.ValueOutput
import br.com.clean.core.business.interactor.UseCase
import com.v2.sample.clean.feature.chainusecase.business.ChainUseCaseRepository
import com.v2.sample.clean.feature.chainusecase.domain.Landing

class ThirdUseCase(
    private val repo: ChainUseCaseRepository
) : UseCase<Void, Landing>() {

    override fun guard(param: Void?): Boolean {
        return super.guard(param)
    }

    override fun onGuardError() {
        super.onGuardError()
    }

    override fun execute(param: Void?): Output<Landing> {
        val landing = repo.doFetch()
        return ValueOutput(landing)
    }
}