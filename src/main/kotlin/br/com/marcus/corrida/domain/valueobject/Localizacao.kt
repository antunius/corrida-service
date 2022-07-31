package br.com.marcus.corrida.domain.valueobject

import javax.persistence.Embeddable

@Embeddable
class Localizacao(
    val latitude: String? = null,
    val longitude: String? = null,
)