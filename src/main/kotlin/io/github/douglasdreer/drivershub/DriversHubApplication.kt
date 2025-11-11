package io.github.douglasdreer.drivershub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DriversHubApplication

fun main(args: Array<String>) {
    runApplication<DriversHubApplication>(*args)
}
