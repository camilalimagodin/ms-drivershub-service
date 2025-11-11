package io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller

import io.github.douglasdreer.drivershub.application.ports.input.CreateBrandUseCase
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller.mapper.toCommand
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller.mapper.toResponse
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.models.BrandResponse
import io.github.douglasdreer.drivershub.infraestructure.adapter.input.models.CreateBrandRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/brands")
class CreateBrandController(
    private val usercase: CreateBrandUseCase
): BaseController() {
    @PostMapping
    fun createBrand(@Validated @RequestBody request: CreateBrandRequest): ResponseEntity<BrandResponse> {
        val brandDomain = usercase.execute(request.toCommand())
        val endpoint = createURI(brandDomain.id, "brands")
        return ResponseEntity
            .created(endpoint)
            .body(brandDomain.toResponse())
    }
}