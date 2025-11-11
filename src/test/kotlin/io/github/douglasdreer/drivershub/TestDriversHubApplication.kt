package io.github.douglasdreer.drivershub

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<DriversHubApplication>().with(TestcontainersConfiguration::class).run(*args)
}
