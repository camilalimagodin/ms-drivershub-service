package io.github.douglasdreer.drivershub.infraestructure.adapter.input.models

import java.time.LocalDateTime

data class BrandResponse(
    val id: Long? = 1L,
    val name: String,
    val site: String,
    val logoUrl: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val status: Boolean
)