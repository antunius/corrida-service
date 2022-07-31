package br.com.marcus.corrida.domain

import br.com.marcus.corrida.domain.enums.FormaPagamento
import br.com.marcus.corrida.domain.valueobject.Localizacao

data class CorridaDTO(
    val passageiroId: Long,
    val tipoCorrida: Long,
    val formaPagamento: FormaPagamento,
    var partida: Localizacao,
    var destino: Localizacao,
)