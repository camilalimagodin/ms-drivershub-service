package io.github.douglasdreer.drivershub.domain.exception

import org.springframework.http.HttpStatus

class BrandNotFoundException(brandId: Long): BusinessException("Brand not found", HttpStatus.NOT_FOUND)