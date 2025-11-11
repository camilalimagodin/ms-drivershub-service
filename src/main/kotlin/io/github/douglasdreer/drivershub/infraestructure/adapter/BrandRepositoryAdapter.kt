package io.github.douglasdreer.drivershub.infraestructure.adapter

import io.github.douglasdreer.drivershub.application.ports.output.BrandServiceRespositoryPort
import io.github.douglasdreer.drivershub.domain.model.Brand
import io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.mapper.toDomain
import io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.mapper.toEntity
import io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.repository.SpringDataBrandRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class BrandRepositoryAdapter(
    private val repository: SpringDataBrandRepository,
): BrandServiceRespositoryPort {
    override fun existsById(brandId: Long): Boolean {
        return repository.existsById(brandId)
    }

    override fun findAll(): List<Brand> {
        return repository
            .findAll()
            .map { it.toDomain() }
    }

    override fun findById(brandId: Long): Brand? {
        val brandFound = repository.findByIdOrNull(brandId)
        return brandFound?.toDomain()
    }

    override fun save(brand: Brand): Brand {
        return repository
            .save(brand.toEntity())
            .toDomain()
    }

    override fun update(brand: Brand): Brand {
        return repository
            .save(brand.toEntity())
            .toDomain()
    }

    override fun deleteById(brandId: Long) {
        repository.deleteById(brandId)
    }
}