package com.example.demo.resources.controllers

import com.example.demo.data.dto.TodoDTO
import com.example.demo.data.dto.UtcDto
import com.example.demo.domain.models.Todo
import com.example.demo.domain.services.WorldClockService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/world-clock")
class WorldClockResourceController {

    @Autowired
    private lateinit var service: WorldClockService

    @GetMapping
    fun getUTC(): ResponseEntity<UtcDto> {
        val dto = service.fetchDataFromExternalApi()
        return ResponseEntity.ok().body(dto)
    }

}