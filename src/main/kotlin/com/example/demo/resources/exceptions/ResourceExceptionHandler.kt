package com.example.demo.resources.exceptions

import com.example.demo.domain.services.exceptions.DatabaseException
import com.example.demo.domain.services.exceptions.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(resourceNotFoundException: ResourceNotFoundException,
                                  httpServletRequest: HttpServletRequest): ResponseEntity<StandardError> {

        val errorMessage: String = "Resource not found!"
        val httpStatus: HttpStatus = HttpStatus.NOT_FOUND
        val standardError = StandardError(Instant.now(), httpStatus.value(), errorMessage,
                resourceNotFoundException.message, httpServletRequest.requestURI)
        return ResponseEntity.status(httpStatus).body(standardError)
    }

    @ExceptionHandler(DatabaseException::class)
    fun databaseException(databaseException: DatabaseException,
                          httpServletRequest: HttpServletRequest): ResponseEntity<StandardError> {

        val errorMessage: String = "Resource not found!"
        val httpStatus: HttpStatus = HttpStatus.NOT_FOUND
        val standardError = StandardError(Instant.now(), httpStatus.value(), errorMessage,
                databaseException.message, httpServletRequest.requestURI)
        return ResponseEntity.status(httpStatus).body(standardError)
    }
}