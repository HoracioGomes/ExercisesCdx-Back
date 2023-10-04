package com.example.demo.resources.controllers

import com.example.demo.data.dto.TodoDTO
import com.example.demo.domain.models.Todo
import com.example.demo.domain.services.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoResourceController {

    @Autowired
    private lateinit var service: TodoService

    @GetMapping
    fun getAllTodo(): ResponseEntity<List<Todo>> {
        val todoList: List<Todo> = service.findAll()
        return ResponseEntity.ok().body(todoList)
    }

    @PostMapping
    fun addTodo(@RequestBody dto: TodoDTO): ResponseEntity<Todo> {
        val todo = service.save(dto)
        return ResponseEntity.ok().body(todo)
    }

    @DeleteMapping("delete/{id}")
    fun deleteTodo(@PathVariable id: Long) {
        service.deleteById(id)
    }
}