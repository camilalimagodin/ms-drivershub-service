package io.github.douglasdreer.drivershub.application.ports.input

data class UpdateBrandCommand(
    val id: Long,
    val name: String,
    val site: String,
    val logoUrl: String,
    val status: Boolean
)
