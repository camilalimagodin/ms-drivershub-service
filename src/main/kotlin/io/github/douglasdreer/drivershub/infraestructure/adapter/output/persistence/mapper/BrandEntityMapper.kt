package io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.mapper

import io.github.douglasdreer.drivershub.domain.model.Brand
import io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.entity.BrandEntity

fun Brand.toEntity() = BrandEntity(
    id = this.id,
    name = this.name,
    site = this.site,
    logoUrl = this.logoUrl,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    status = this.status
)

fun BrandEntity.toDomain() = Brand(
    id = this.id,
    name = this.name,
    site = this.site,
    logoUrl = this.logoUrl,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    status = this.status
)