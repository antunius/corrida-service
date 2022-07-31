package br.com.marcus.corrida.domain.services

import br.com.marcus.corrida.domain.CorridaDTO
import br.com.marcus.corrida.domain.factories.CorridaFactory
import br.com.marcus.corrida.domain.repositories.CorridaRepository
import br.com.marcus.corrida.domain.entities.TipoCorrida
import br.com.marcus.corrida.domain.repositories.TipoCorridaRepository
import br.com.marcus.corrida.resource.PassageiroService
import com.fasterxml.jackson.core.JsonProcessingException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CorridaServiceImpl(
    private val repository: CorridaRepository,
    private val passageiroService: PassageiroService,
    private val tipoCorridaRepository: TipoCorridaRepository,
    //private var jmsTemplate: JmsTemplate,
) : CorridaService {


    override fun chamarCorrida(corridaDTO: CorridaDTO) {
        val passageiro = passageiroService.buscarPassageiro(corridaDTO.passageiroId)
        val tipoCorrida = tipoCorrida(corridaDTO.tipoCorrida)
        val corridaSolicitada = CorridaFactory.corridaSolicitada(
            passageiro,
            tipoCorrida,
            corridaDTO
        )
        try {
            corridaSolicitada.let {
                repository.save(it)
                //jmsTemplate.convertAndSend("corrida", it.toJSON())
            }
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }
    }

    fun tipoCorrida(tipoCorridaId: Long): TipoCorrida {
        tipoCorridaRepository.save(TipoCorrida(tipoCorridaId, ""))
        return tipoCorridaRepository.findById(1).get()
    }

    /*
        @JmsListener(destination = "corrida-aceita")
        override fun corridaAceita(message: SQSTextMessage) {
            try {
                message.text?.toObject<CorridaAceita>().also { event ->
                    findCorridaByUUID(event!!.uuid).ifPresentOrElse({ corrida ->
                        corrida.aceita(event.motorista).also {
                            repository.save(it)
                        }
                        println("Notifica Usuario")
                    }, {
                        throw CorridaNotFoundException()
                    })
                }
                message .acknowledge()
            } catch (e: JsonProcessingException) {
                e.printStackTrace()
            } catch (e: JMSException) {
                e.printStackTrace()
            }
        }

        override fun tipoCorrida(tipoCorridaId: Long): br.com.marcus.corrida.domain.entities.TipoCorrida {
            return br.com.marcus.corrida.domain.entities.TipoCorrida(tipoCorridaId, "")
        }

        @JmsListener(destination = "corrida-iniciada")
        override fun corridaEmAndamento(message: SQSTextMessage) {
            try {
                message.text.toObject<CorridaIniciada>().also { event ->
                    findCorridaByUUID(event.uuid).ifPresent { corrida ->
                        if (corrida.motorista?.id.notEquals(event.motorista?.id)) throw CorridaException()
                        corrida.iniciar().also {
                            repository.save(corrida)
                        }
                        println("Notifica Usuario")
                    }
                }
            } catch (e: JsonProcessingException) {
                e.printStackTrace()
            } catch (e: JMSException) {
                e.printStackTrace()
            }
        }

        @JmsListener(destination = "corrida-finalizada")
        override fun corridaFinalizada(message: SQSTextMessage) {
            try {
                message.text.toObject<CorridaFinalizada>().also { event ->
                    findCorridaByUUID(event.uuid).ifPresent { corrida ->
                        corrida.finalizar().also {
                            repository.save(it)
                        }
                        println("Notifica Usuario")
                    }
                }

            } catch (e: JsonProcessingException) {
                e.printStackTrace()
            } catch (e: JMSException) {
                e.printStackTrace()
            }
        }


     */
    private fun findCorridaByUUID(uuid: UUID) = repository.findById(uuid)
}
