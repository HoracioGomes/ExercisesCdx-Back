package com.example.demo.infrastructure.repositories

import com.example.demo.infrastructure.models.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}