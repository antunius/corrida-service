package br.com.marcus.corrida.domain.repositories

import br.com.marcus.corrida.domain.entities.Corrida
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CorridaRepository : JpaRepository<Corrida, UUID> {
    fun save(corrida: Corrida?)
}