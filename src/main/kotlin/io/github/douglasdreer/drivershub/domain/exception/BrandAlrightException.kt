package io.github.douglasdreer.drivershub.domain.exception

import org.springframework.http.HttpStatus

class BrandAlrightException(data: Any): BusinessException("Brand alright with field $data", HttpStatus.CONFLICT)