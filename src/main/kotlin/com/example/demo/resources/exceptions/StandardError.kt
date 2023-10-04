package com.example.demo.resources.exceptions

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serial
import java.io.Serializable
import java.time.Instant

class StandardError(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM--dd'T'HH:mm:ss'Z'", timezone = "GMT")
        var timestamp: Instant,
        var status: Int,
        var error: String,
        var message: String?,
        var path: String,

        ) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4645741718801329429L
    }
}