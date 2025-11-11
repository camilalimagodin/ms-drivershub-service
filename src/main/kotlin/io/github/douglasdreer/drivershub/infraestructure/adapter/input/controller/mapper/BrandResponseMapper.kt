package io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller.mapper

import io.github.douglasdreer.drivershub.domain.model.Brand
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.models.BrandResponse

fun Brand.toResponse() = BrandResponse(
    id = this.id,
    name = this.name,
    site = this.site,
    logoUrl = this.logoUrl,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    status = this.status
)