package com.example.demo.resources

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serial
import java.io.Serializable
import java.time.Instant

class StandardError(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd'T'HH:mm:ss'Z'", timezone = "GMT")
        private var timestamp: Instant,
        private var status: Int,
        private var error: String,
        private var message: String?,
        private var path: String,

        ) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4645741718801329429L
    }
}