package com.example.demo.data.repositories

import com.example.demo.domain.models.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}