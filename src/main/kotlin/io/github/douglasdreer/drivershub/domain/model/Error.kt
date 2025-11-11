package io.github.douglasdreer.drivershub.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class Error(
    val status: Int,
    val message: String,
    val description: String,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val details: Map<String, Any?> = emptyMap(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
)
