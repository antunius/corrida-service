package br.com.marcus.corrida.domain.services

import br.com.marcus.corrida.domain.CorridaDTO

/**
 * The interface br.com.marcus.corrida.domain.entity.Corrida service.
 */
interface CorridaService {
    /**
     * Chamar corrida.
     *
     * @param corrida the corrida
     */
    fun chamarCorrida(corrida: CorridaDTO)

/*
    fun corridaAceita(message: SQSTextMessage)
    fun corridaEmAndamento(message: SQSTextMessage)
    fun corridaFinalizada(message: SQSTextMessage)
    fun tipoCorrida(tipoCorridaId: Long): br.com.marcus.corrida.domain.entities.TipoCorrida

 */
}