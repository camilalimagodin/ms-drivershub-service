package io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller.mapper

import io.github.douglasdreer.drivershub.application.ports.input.CreateBrandCommand
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.models.CreateBrandRequest


fun CreateBrandRequest.toCommand(): CreateBrandCommand {
    return CreateBrandCommand(
        name = this.name,
        site = this.site,
        logoUrl = this.logoUrl,
        status = true
    )
}