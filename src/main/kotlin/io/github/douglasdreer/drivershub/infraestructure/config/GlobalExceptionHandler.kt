package io.github.douglasdreer.drivershub.infraestructure.config

import io.github.douglasdreer.drivershub.domain.exception.BrandInvalidParameterException
import io.github.douglasdreer.drivershub.domain.exception.BrandNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import io.github.douglasdreer.drivershub.domain.model.Error
import org.apache.coyote.BadRequestException

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BrandNotFoundException::class)
    fun handleNotFound(ex: BrandNotFoundException): ResponseEntity<Error> {
        return ResponseEntity
            .status(ex.status)
            .body(
                Error(
                    status = ex.status.value(),
                    message = ex.message ?: "Brand not found",
                    description = "The requested brand was not found in the system"
                )
            )
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequest(ex: BadRequestException): ResponseEntity<Error> {
        return ResponseEntity
            .badRequest()
            .body(
                Error(
                    status = 400,
                    message = ex.message ?: "Bad request",
                    description = "The request could not be understood or was missing required parameters"
                )
            )
    }

    @ExceptionHandler(BrandInvalidParameterException::class)
    fun handleInvalidParameter(ex: BrandInvalidParameterException): ResponseEntity<Error> {
        return ResponseEntity
            .status(ex.status)
            .body(
                Error(
                    status = ex.status.value(),
                    message = ex.message ?: "Invalid parameters",
                    description = "Has invalid parameters in the request",
                    details = ex.parameterList
                )
            )
    }
}