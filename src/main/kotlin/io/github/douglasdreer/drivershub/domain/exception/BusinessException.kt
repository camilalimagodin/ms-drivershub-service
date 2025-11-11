package io.github.douglasdreer.drivershub.domain.exception

import org.springframework.http.HttpStatus

abstract class BusinessException(message: String, val status: HttpStatus) : RuntimeException(message)