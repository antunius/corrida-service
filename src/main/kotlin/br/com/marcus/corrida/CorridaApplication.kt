package br.com.marcus.corrida

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CorridaApplication

fun main(args: Array<String>) {
    runApplication<CorridaApplication>(*args)
}
