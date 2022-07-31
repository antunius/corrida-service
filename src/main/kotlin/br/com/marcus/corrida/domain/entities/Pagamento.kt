package br.com.marcus.corrida.domain.entities

import br.com.marcus.corrida.domain.enums.FormaPagamento
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Pagamento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Enumerated(EnumType.STRING) val formaPagamento: FormaPagamento,
    @Column(precision = 10, scale = 2) val valor: BigDecimal? = null,
    val dataPagamento: LocalDateTime? = LocalDateTime.now(),
)