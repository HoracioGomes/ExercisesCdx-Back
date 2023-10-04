package com.example.demo.services

import com.example.demo.infrastructure.models.Todo
import com.example.demo.infrastructure.repositories.TodoRepository
import com.example.demo.services.exceptions.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class TodoService {
    @Autowired
    private lateinit var repository: TodoRepository
    fun save(todo: Todo): Todo {
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