package com.example.demo.domain.services

import com.example.demo.data.dto.TodoDTO
import com.example.demo.domain.models.Todo
import com.example.demo.data.repositories.TodoRepository
import com.example.demo.domain.services.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId

@Service
class TodoService {
    @Autowired
    private lateinit var repository: TodoRepository
    fun save(dto: TodoDTO): Todo {
        val todo = Todo(id = null, titulo = dto.titulo, descricao = dto.descricao,
                dataAgendada = LocalDateTime.parse(dto.dataAgendada),
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