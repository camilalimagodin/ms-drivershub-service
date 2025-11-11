package io.github.douglasdreer.drivershub.application.usecase

import io.github.douglasdreer.drivershub.application.mapper.toDomain
import io.github.douglasdreer.drivershub.application.ports.input.CreateBrandUseCase
import io.github.douglasdreer.drivershub.application.ports.input.CreateBrandCommand
import io.github.douglasdreer.drivershub.domain.model.Brand
import io.github.douglasdreer.drivershub.infraestructure.adapter.BrandRepositoryAdapter
import org.springframework.stereotype.Service

@Service
class CreateBrandUseCaseImpl(
    private val servicePort: BrandRepositoryAdapter,
): CreateBrandUseCase {
    override fun execute(createBrandCommand: CreateBrandCommand): Brand {
        val brandCreated = servicePort.save(createBrandCommand.toDomain())
        return brandCreated
    }
}