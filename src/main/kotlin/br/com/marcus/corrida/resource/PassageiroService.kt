package br.com.marcus.corrida.resource

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "passageiro", url = "\${url.service.passageiro}",)
interface PassageiroService {
    @GetMapping("/{passageiroId}")
    fun buscarPassageiro(@PathVariable passageiroId: Long): Passageiro
}