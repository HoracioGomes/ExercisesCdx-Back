package com.example.demo.domain.services

import com.example.demo.data.dto.TodoDTO
import com.example.demo.domain.models.Todo
import com.example.demo.data.repositories.TodoRepository
import com.example.demo.domain.services.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Service
class TodoService {
    @Autowired
    private lateinit var repository: TodoRepository
    fun save(dto: TodoDTO): Todo {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(dto.dataAgendada, formatter)

        val todo = Todo(id = null, titulo = dto.titulo, descricao = dto.descricao,
                dataAgendada = LocalDateTime.of(localDate, LocalTime.now()),
                concluida = false)
        return repository.save(todo)
    }

    fun deleteById(idTodo: Long) {
        try {
            return repository.deleteById(idTodo)
        } catch (e: EmptyResultDataAccessException) {
            throw ResourceNotFoundException(idTodo.toString())
        }
    }

    fun findAll(): List<Todo> {
        return repository.findAll()
    }

    fun findById(idTodo: Long): Todo {
        return repository.findById(idTodo).orElseThrow {
            ResourceNotFoundException(idTodo.toString())
        }
    }
}