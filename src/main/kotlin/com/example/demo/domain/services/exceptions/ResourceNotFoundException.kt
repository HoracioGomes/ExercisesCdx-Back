package com.example.demo.domain.services.exceptions

import java.io.Serial

class ResourceNotFoundException(override var message: String) : RuntimeException()  {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -9650252030229868L
    }
}