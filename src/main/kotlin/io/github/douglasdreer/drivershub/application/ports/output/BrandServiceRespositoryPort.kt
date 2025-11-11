package io.github.douglasdreer.drivershub.application.ports.output

import io.github.douglasdreer.drivershub.domain.model.Brand

interface BrandServiceRespositoryPort {
    fun existsById(brandId: Long): Boolean
    fun findAll(): List<Brand>
    fun findById(brandId: Long): Brand?
    fun save(brand: Brand): Brand
    fun update(brand: Brand): Brand
    fun deleteById(brandId: Long)
}