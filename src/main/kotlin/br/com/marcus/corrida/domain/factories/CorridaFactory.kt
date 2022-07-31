package br.com.marcus.corrida.domain.factories

import br.com.marcus.corrida.domain.CorridaDTO
import br.com.marcus.corrida.domain.entities.Avaliacao
import br.com.marcus.corrida.domain.entities.Corrida
import br.com.marcus.corrida.domain.entities.Pagamento
import br.com.marcus.corrida.domain.enums.CorridaStatus
import br.com.marcus.corrida.domain.entities.TipoCorrida
import br.com.marcus.corrida.resource.Passageiro

object CorridaFactory {
    @JvmStatic
    fun corridaSolicitada(
        passageiro: Passageiro,
        tipoCorrida: TipoCorrida,
        corridaDTO: CorridaDTO,
    ): Corrida {
        return Corrida(
            passageiroId = passageiro.id,
            partida = corridaDTO.partida,
            destino = corridaDTO.destino,
            tipoCorrida = tipoCorrida,
            motoristaId = null,
            status = CorridaStatus.SOLICITADO,
            avaliacao = Avaliacao(),
            pagamento = Pagamento(formaPagamento = corridaDTO.formaPagamento),
            veiculoId = null
        )

    }
}