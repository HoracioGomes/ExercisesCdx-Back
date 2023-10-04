package com.example.demo.domain.models

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serial
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@Table(name = "todo")
data class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @Column(length = 255)
        var titulo: String = "",
        @Column(length = 255)
        var descricao: String = "",
        @Column(name = "data_agendada")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd'T'HH:mm:ss'Z'", timezone = "GMT")
        var dataAgendada: LocalDateTime = LocalDateTime.now(),
        var concluida: Boolean = false,
) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -7862319138907049466L
    }
}