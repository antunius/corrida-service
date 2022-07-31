package br.com.marcus.corrida.domain.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: UUID? = null
    private val nota: Long? = null
    private val comentario: String? = null
}