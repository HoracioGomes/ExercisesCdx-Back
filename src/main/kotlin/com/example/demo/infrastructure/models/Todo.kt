package com.example.demo.infrastructure.models

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
        private val id: Long,
        @Column(length = 255)
        private var titulo: String,
        @Column(length = 255)
        private var descricao: String,
        @Column(name = "data_agendada")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd'T'HH:mm:ss'Z'", timezone = "GMT")
        private var dataAgendada: LocalDateTime,
        private var concluida: Boolean,
) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -7862319138907049466L
    }

}