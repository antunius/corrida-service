package br.com.marcus.corrida.resource

import java.time.LocalDate


data class Passageiro(
    val id: Long,
    val nome: String,
    val cpf: String,
    val dataNascimento: LocalDate,
)