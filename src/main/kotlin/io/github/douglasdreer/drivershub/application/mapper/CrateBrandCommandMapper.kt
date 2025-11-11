package io.github.douglasdreer.drivershub.application.mapper

import io.github.douglasdreer.drivershub.application.ports.input.CreateBrandCommand
import io.github.douglasdreer.drivershub.domain.model.Brand

fun CreateBrandCommand.toDomain() = Brand(
    name = this.name,
    site = this.site,
    logoUrl = this.logoUrl,
    status = this.status
)