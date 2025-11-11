package io.github.douglasdreer.drivershub.domain.exception

import org.springframework.http.HttpStatus

class BrandInvalidParameterException(
    val parameterList: Map<String, Any?>
) : BusinessException(
    "Invalid parameter(s): ${parameterList.keys.joinToString(", ")}",
    HttpStatus.BAD_REQUEST
)