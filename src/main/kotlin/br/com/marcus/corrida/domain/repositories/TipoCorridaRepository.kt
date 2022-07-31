package br.com.marcus.corrida.domain.repositories

import br.com.marcus.corrida.domain.entities.TipoCorrida
import org.springframework.data.jpa.repository.JpaRepository

interface TipoCorridaRepository : JpaRepository<TipoCorrida, Long> {
    fun save(tipoCorrida: TipoCorrida)
}