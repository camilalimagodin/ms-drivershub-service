package io.github.douglasdreer.drivershub.application.ports.input

import io.github.douglasdreer.drivershub.domain.model.Brand

fun interface CreateBrandUseCase {
    fun execute(createBrandCommand: CreateBrandCommand): Brand
}