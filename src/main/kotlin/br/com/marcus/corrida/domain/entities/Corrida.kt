package br.com.marcus.corrida.domain.entities

import br.com.marcus.corrida.domain.enums.CorridaStatus
import br.com.marcus.corrida.domain.valueobject.Localizacao
import br.com.marcus.corrida.exception.CorridaStatusInvalidoException
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
class Corrida(
    @Id
    val id: UUID = UUID.randomUUID(),
    val passageiroId: Long,
    @Embedded
    @AttributeOverride(name = "latitude", column = Column(name = "partida_latitude"))
    @AttributeOverride(name = "longitude", column = Column(name = "partida_longitude"))
    val partida: Localizacao,
    @Embedded
    @AttributeOverride(name = "latitude", column = Column(name = "destino_latitude"))
    @AttributeOverride(name = "longitude", column = Column(name = "destino_longitude"))
    val destino: Localizacao,
    @Enumerated(EnumType.STRING)
    var status: CorridaStatus,

    @OneToOne
    @JoinColumn(name = "tipo_corrida", referencedColumnName = "id")
    val tipoCorrida: TipoCorrida,
    var motoristaId: Long?,

    val veiculoId: Long?,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "avaliacao_id", referencedColumnName = "id")
    var avaliacao: Avaliacao? = null,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    var pagamento: Pagamento,
    var inicioCorrida: LocalDateTime? = null,
    var fimCorrida: LocalDateTime? = null,

    ) {

    fun aceita(motoristaId: Long): Corrida {
        if (status == CorridaStatus.A_CAMINHO) throw CorridaStatusInvalidoException()
        this.motoristaId = motoristaId
        status = CorridaStatus.A_CAMINHO
        println("Corrida $id aceita pelo motorista $motoristaId")
        return this
    }

    fun iniciar(): Corrida {
        status = CorridaStatus.EM_ANDAMENTO
        inicioCorrida = LocalDateTime.now()
        println("Corrida $id iniciada pelo motorista $motoristaId")
        return this
    }

    fun finalizar(): Corrida {
        this.fimCorrida = LocalDateTime.now()
        this.status = CorridaStatus.FINALIZADO
        println("Corrida $id finalizada pelo motorista $motoristaId")
        return this
    }
}