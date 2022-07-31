package br.com.marcus.corrida.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class TipoCorrida(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 1,
    val descricao: String? = null,
)