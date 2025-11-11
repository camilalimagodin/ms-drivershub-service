package io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.repository

import io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.entity.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository


interface SpringDataBrandRepository : JpaRepository<BrandEntity, Long> {
}