package com.example.demo.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
open class CorsConfiguration : OncePerRequestFilter() {
    override fun doFilterInternal(
            httpServletRequest: HttpServletRequest,
            httpServletResponse: HttpServletResponse,
            filterChain: FilterChain
    ) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*")
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "*")
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "*")

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}