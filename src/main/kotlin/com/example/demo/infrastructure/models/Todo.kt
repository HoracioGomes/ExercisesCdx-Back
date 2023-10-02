package com.example.demo.infrastructure.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

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
        private var dataAgendada: String,
        private var concluida: Boolean,
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }

}