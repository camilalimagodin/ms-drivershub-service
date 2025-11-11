package io.github.douglasdreer.drivershub.infraestructure.adapter.input.controller

import java.net.URI

abstract class BaseController {
    fun createURI(id: Long?, path: String): URI {
        return URI.create("/api/v1/$path/$id")
    }
}