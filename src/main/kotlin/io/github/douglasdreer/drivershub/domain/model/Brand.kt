package io.github.douglasdreer.drivershub.domain.model

import java.time.LocalDateTime

data class Brand(
    val id: Long ? = null,
    val name: String,
    val site: String,
    val logoUrl: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val status: Boolean
)