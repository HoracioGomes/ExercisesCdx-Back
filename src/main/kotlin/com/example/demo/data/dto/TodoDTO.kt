package com.example.demo.data.dto

import com.fasterxml.jackson.annotation.JsonAlias
import java.time.LocalDateTime

class TodoDTO(
        var titulo: String,
        var descricao: String,
        @JsonAlias("date")
        var dataAgendada: String,
)