package com.example.demo.domain.services

import com.example.demo.data.dto.UtcDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient


@Service
class WorldClockService(webClientBuilder: WebClient.Builder) {

    private val webClient: WebClient =
            webClientBuilder.baseUrl("http://worldclockapi.com/api/json/utc/now").build()

    fun fetchDataFromExternalApi(): UtcDto? {
        val response = webClient.get()
                .retrieve()
                .bodyToMono(UtcDto::class.java)
        return response.block()

    }


}