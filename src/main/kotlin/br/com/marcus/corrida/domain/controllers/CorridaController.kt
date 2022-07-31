package br.com.marcus.corrida.domain.controllers

import br.com.marcus.corrida.domain.CorridaDTO
import br.com.marcus.corrida.domain.services.CorridaService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * The type br.com.marcus.corrida.domain.entity.Corrida controller.
 */
@RestController
@RequestMapping("/corrida")
class CorridaController(val corridaService: CorridaService) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun novaCorrida(@RequestBody corridaDTO: CorridaDTO) {
      //  logger.info("Hello Sleuth")
        corridaService.chamarCorrida(corridaDTO)
    }
}