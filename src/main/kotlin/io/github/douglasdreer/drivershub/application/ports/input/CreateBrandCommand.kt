package io.github.douglasdreer.drivershub.application.ports.input

import org.hibernate.validator.constraints.URL
import org.jetbrains.annotations.NotNull

data class CreateBrandCommand(
    @field:NotNull("Name cannot be null")
    val name: String,
    @field:NotNull("Site cannot be null")
    val site: String,
    @field:URL(message = "URL cannot be empty")
    val logoUrl: String,
    val status: Boolean = true
)
