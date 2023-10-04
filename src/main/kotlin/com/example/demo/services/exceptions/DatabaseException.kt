package com.example.demo.services.exceptions

import java.io.Serial

class DatabaseException : RuntimeException() {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -7679554474980420268L
    }


}