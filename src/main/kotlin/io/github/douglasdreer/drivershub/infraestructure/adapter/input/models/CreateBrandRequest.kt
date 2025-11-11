package io.github.douglasdreer.drivershub.infraestructure.adapter.input.models

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateBrandRequest(
    @field:NotBlank
    @field:Size(min = 1, max = 255)
    val name: String,
    val site: String,
    val logoUrl: String
)
